// Install the Java helper library from twilio.com/docs/java/install
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.taskrouter.v1.workspace.worker.Reservation;

public class Example {
  private static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
  private static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
  private static final String WORKSPACE_SID = "WSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
  private static final String WORKER_SID = "WKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    ResourceSet<Reservation> reservations = Reservation.reader(WORKSPACE_SID, WORKER_SID).read();

    for (Reservation reservation : reservations) {
      System.out.println(reservation.getReservationStatus());
      System.out.println(reservation.getWorkerName());
    }
  }
}

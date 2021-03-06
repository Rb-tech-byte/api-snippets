<?php
// Get the PHP helper library from https://twilio.com/docs/libraries/php
require_once '/path/to/vendor/autoload.php'; // Loads the library
use Twilio\Rest\Client;

// Your Account Sid and Auth Token from twilio.com/user/account
// To set up environmental variables, see http://twil.io/secure
$sid = getenv('TWILIO_ACCOUNT_SID');
$token = getenv('TWILIO_AUTH_TOKEN');
$client = new Client($sid, $token);

// Get an object from its sid. If you do not have a sid,
// check out the list resource examples on this page
$participant = $client
    ->conferences("CFbbe4632a3c49700934481addd5ce1659")
    ->participants("CA386025c9bf5d6052a1d1ea42b4d16662")
    ->update(array("muted" => "True"));

echo $participant->muted;

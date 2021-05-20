<?php
if ($_SERVER ['REQUEST_METHOD'] == 'POST'){
    require_once("db.php");

    $name = $_POST ['name'];
    $email = $_POST ['email'];
    $pass = $_POST ['pass'];
    $phone = $_POST ['phone'];


    $query = "INSERT INTO users (name,email,pass,phone) VALUES('$name' , '$email' , '$pass' , '$phone')";

    $result = $mysql -> query ($query);

    if ($result == TRUE){
        echo "the user was register successfully";
    } else {

        echo "error";
    }
    $mysql-> close ();



}
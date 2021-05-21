<?php
if ($_SERVER ['REQUEST_METHOD'] == 'POST'){
    require_once("db.php");

    $name = $_POST['username'];
    $pass = $_POST['pass'];
    

    $query = "select * from users where name = '$name' and pass = '$pass'";

    $result = $mysql -> query ($query);
//    var_dump($result);
    // exit();
    if ($result->num_rows>= 1){
        echo "acceso permitido!";
    } else {

        echo "error";
    }
    $mysql-> close ();



}

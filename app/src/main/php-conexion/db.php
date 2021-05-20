<?php

  $mysql = new mysqli(
   "localhost",
   "root",
   "",
   "proyectapp"

  );

  if ($mysql ->connect_error){
      die("failed to connect" . $mysql->connect_error);
  } else {
      echo"succesfully";
  }
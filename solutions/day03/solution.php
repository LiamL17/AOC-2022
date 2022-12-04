<?php
$sum = 0;
$sum2 = 0;
$lineNum = 0;
$handle = fopen("day03.txt", "r");
$s1 = "";
$s2 = "";
if ($handle) {
    while (($line = fgets($handle)) !== false) {
        $result = 0;
        if ($lineNum == 0) {
            $s1 = $line;
        } else if ($lineNum == 1) {
            $s2 = $line;
        } else {
            $result = array_values(array_intersect(str_split($s1), str_split($s2), str_split($line)))[0];
            if (ord($result) - 96 > 0) {
                $ansOrd = ord($result) - 96;
            } else {
                $ansOrd = ord($result) - 64 + 26;
            }

            $sum2 += $ansOrd;
            $lineNum = -1;
        }
        $lineNum += 1;

        $splitLeft = substr($line, 0, strlen($line) / 2);
        $splitRight = substr($line, strlen($line) / 2);
        $result = array_values(array_intersect(str_split($splitLeft), str_split($splitRight)))[0];

        $ansOrd = 0;
        if (ord($result) - 96 > 0) {
            $ansOrd = ord($result) - 96;
        } else {
            $ansOrd = ord($result) - 64 + 26;
        }

        $sum += $ansOrd;
    }

    fclose($handle);
}

    printf("Sum of values: %d  \n", $sum);
    printf("Sum of 3-group values: %d \n", $sum2);
?>
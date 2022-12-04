Module VBModule
  Sub Main()
    Dim strFile, strLine as String
    Dim totalPointsPt1, totalPointsPt2, game1, game2 as Integer

    totalPointsPt1 = 0
    totalPointsPt2 = 0

    strFile = "input.txt"
    Open strFile For Input As #1
    Do Until EOF(1)
      Line Input #1, strLine
      Select Case strLine
        Case "A X"
          game1 = 3 + 1
        Case "A Y"
          game1 = 6 + 2
        Case "A Z"
          game1 = 0 + 3

        Case "B X"
          game1 = 0 + 1
        Case "B Y"
          game1 = 3 + 2
        Case "B Z"
          game1 = 6 + 3

        Case "C X"
          game1 = 6 + 1
        Case "C Y"
          game1 = 0 + 2
        Case "C Z"
          game1 = 3 + 3
      End Select

      Select Case strLine
        Case "A X"
          game1 = 0 + 3
        Case "A Y"
          game1 = 3 + 1
        Case "A Z"
          game1 = 6 + 2

        Case "B X"
          game1 = 0 + 1
        Case "B Y"
          game1 = 3 + 2
        Case "B Z"
          game1 = 6 + 3

        Case "C X"
          game1 = 0 + 2
        Case "C Y"
          game1 = 3 + 3
        Case "C Z"
          game1 = 6 + 1
      End Select
      totalPointsPt1 = totalPointsPt1 + game1
      totalPointsPt2 = totalPointsPt2 + game2
    Loop
    Close #1
    Console.WriteLine("Total points of all games played (pt1): {0}", totalPointsPt1)
    Console.WriteLine("Total points of all games played (pt2): {0}", totalPointsPt2)
  End Sub
End Module
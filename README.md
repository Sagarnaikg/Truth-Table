# Truth-Table
Program to print truth table of a boolean expression

The sample output of the program :-

output 1 :-
```
Enter the Valid expression which only consists of logic gates AND,OR,T,F  give the expression in the form expression1 <=> expression2
Expression = a^bvc <=> cvb^a

Enter the number of variables used = 3
Enter the variable used = 
1th variable  a
2th variable  b
3th variable  c


Truth Table :

    a     |    b     |    c     |      a&b|c                     |       c|b&a                |
-----------------------------------------------------------------------------------------------
    0     |    0     |    0     |        0                       |         0                  |

    0     |    0     |    1     |        1                       |         1                  |

    0     |    1     |    0     |        0                       |         0                  |

    0     |    1     |    1     |        1                       |         1                  |

    1     |    0     |    0     |        0                       |         0                  |

    1     |    0     |    1     |        1                       |         1                  |

    1     |    1     |    0     |        1                       |         1                  |

    1     |    1     |    1     |        1                       |         1                  |

The expression is valid
```
output 2  :-

Enter the Valid expression which only consists of logic gates AND,OR,T,F  give the expression in the form expression1 <=> expression2
Expression = a^b <=> bva

Enter the number of variables used = 2
Enter the variable used = 
1th variable  a
2th variable  b


Truth Table :

    a     |    b     |      a&b                       |       b|a                  |
-------------------------------------------------------------------------------------
    0     |    0     |        0                       |         0                  |

    0     |    1     |        0                       |         1                  |

    1     |    0     |        0                       |         1                  |

    1     |    1     |        1                       |         1                  |

The expression is invalid





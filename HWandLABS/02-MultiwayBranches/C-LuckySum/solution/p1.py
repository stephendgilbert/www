##FORBIDDEN or|and
##You cannot use the logical operators and/or with this problem
##CALL 1,2,3
##CALL 1,2,13
##CALL 1,13,3
##CALL 1,13,13
##CALL 6,5,2
##CALL 13,2,3
##CALL 13,2,13
##CALL 13,13,2
##CALL 9,4,13
##CALL 8,13,2
##CALL 7,2,1
##CALL 3,3,13
def luckySum(a, b, c):
    if a == 13: return 0
    if b == 13: return a
    if c == 13: return a + b
    return a + b + c

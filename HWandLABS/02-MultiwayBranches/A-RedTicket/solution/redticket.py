##FORBIDDEN or|and
##You cannot use the logical operators and/or with this problem
##CALL 2,2,2
##CALL 2,2,1
##CALL 0,0,0
##CALL 2,0,0
##CALL 1,1,1
##CALL 1,2,1
##CALL 1,2,0
##CALL 0,2,2
##CALL 1,2,2
##CALL 0,2,0
##CALL 1,1,2
def redTicket(a, b, c):
    if a == b:
        if b == c:
            if a == 2:
                return 10
            return 5
        return 0;
    if a != c:
        return 1
    return 0

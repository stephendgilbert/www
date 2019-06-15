##FORBIDDEN or|and
##You cannot use the logical operators and/or with this problem
##CALL 2,4,6
##CALL 4,6,2
##CALL 4,6,3
##CALL 6,2,4
##CALL 6,2,8
##CALL 2,2,2
##CALL 2,2,3
##CALL 9,10,11
##CALL 10,9,11
##CALL 10,9,9
##CALL 2,4,4
##CALL 2,2,4
##CALL 3,6,12
##CALL 12,3,6
def evenlySpaced(a, b, c):
    result = False;
    if a >= b:
        if b >= c:
            result = b - a == c - b
        elif a >= c:
            result = c - a == b - c
        else :
            result = a - c == b - a
    elif b >= c:
        if a >= c:
            result = a - b == c - a
        else:
            result = c - b == a - c
    else:
        result = b - c == a - b

    return result

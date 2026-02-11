class Solution:
    def strongPasswordCheckerII(self, password):
        len_password = len(password)

        condition_1 = len_password >= 8

        condition_2 = False
        i = 0
        while (i < len_password):
            c = password[i]
            if (ord(c) in range(ord('a'), ord('z')+1)):
                condition_2 = True
            i += 1

        condition_3 = False
        i = 0
        while (i < len_password):
            c = password[i]
            if (ord(c) in range(ord('A'), ord('Z')+1)):
                condition_3 = True
            i += 1

        condition_4 = False
        i = 0
        while (i < len_password):
            c = password[i]
            if (ord(c) in range(ord('0'), ord('9')+1)):
                condition_4 = True
            i += 1

        special_chars_map = {'!': True, '@': True, '#':True, '$':True,'%':True,'^':True,'&':True,'*':True,'(':True,')':True,'-':True,'+':True}
        condition_5 = False
        i = 0
        while (i < len_password):
            c = password[i]
            if (c in special_chars_map.keys()):
                condition_5 = True
            i += 1

        condition_6 = True
        prev_c = None
        i = 0
        while (i < len_password):
            c = password[i]
            if (prev_c is not None and c == prev_c):
                condition_6 = False
            prev_c = c
            i += 1

        return condition_1 and condition_2 and condition_3 and condition_4 and condition_5 and condition_6


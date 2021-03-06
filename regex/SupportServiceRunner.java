package regex;

import regex.service.SupportService;

/**
 * ??????????? ???????? ??????? ????????? ? ????????.
 * <p>
 * ??? ?????? ???????? ???????? ? ??????????????? ??????? ? ???? ?????????? ???-????? ?????????? ??????? (??????? ????????? ????? ???????):
 * <p>
 * - ?????????? ????? ???????
 * - ???? ? ????? ?????? ? ISO ???????
 * - ??????? ? ??? ???????
 * - ??????? ???????
 * - ????? ??????
 * <p>
 * ?????? ????? ?????? ???? ? ????? ?????? ? ???-?????.
 * <p>
 * ????????:
 * 1, 2021-09-13T10:15:30, ?????? ????, +375 29 999 78 90, ?? ?????????? ????
 * 2, 2021-12-22T11:38:16, ?????? ????, +375257777765, ?????? ????? ?? ???????? ?????????
 * 3, 2021-12-28T06:55:24, ?????? ????, 333652193, ???-?? ??????? ??? ?????????? ??????
 * <p>
 * ??????:
 * ? ?????-?? ?????????????? (????????, ??? ? 2 ??????) ????????? ??? ????? ?????? ?? ???-????? ? ?????????? ?? ??????????? ??? ??????? ? ????????? (?????????? ?????????? ???????????, ????????, 2-3).
 * <p>
 * ?????? ?????? ?????-?? ????????????? ????? (????????, 3-5 ??????), ????? ???? ?? ???????????? ? ?????? ???-???? ? ????:
 * - ?????????? ????? ??????? ? ??????????? ??? ?????
 * - ???? ? ????? ???????
 * - ????? ???????? ???????
 * <p>
 * ????????:
 * 2, 2022-01-04 04:15, +375 (25) 777-77-65
 * 1, 2022-01-04 04:30, +375 (29) 999-78-90
 * 3, 2022-01-04 04:45, +375 (33) 365-21-93
 * <p>
 * ?????? ????????? ????? ???? ???????????? ??-???????, ??????? ???????? ?? ? ?????? ???????: +375 (29) 999-78-90.
 * ?????????? ??????????? ?????????? ?????????? ????? ????? ? ????? ???-?????
 */

public class SupportServiceRunner {

    private static final int NUMBER_OF_OPERATORS = 3;

    public static void main(String[] args) {

        var supportService = new SupportService(NUMBER_OF_OPERATORS);
        new Thread(supportService).start();
    }
}
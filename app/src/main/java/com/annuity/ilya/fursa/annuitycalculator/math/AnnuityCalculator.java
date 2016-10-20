package com.annuity.ilya.fursa.annuitycalculator.math;

/**
 * Created by ghost on 11.10.16.
 */

public class AnnuityCalculator {
     /*
    Находим процентную ставку как,
    годовая ставка / 100 / 12 месяцев
     */
    public double calculatePercentRate(double percent) {
        return percent / 100 / 12;
    }

    public double calculateMonthPayment(double primaryCredit, double percentRate, int monthPeriod) {
        double mPay = primaryCredit * (percentRate / (1 - Math.pow(1 + percentRate, -monthPeriod)));
        return mPay;
    }

    /*
    Подсчет переплаты!
    Для того, чтобы посчитать переплату по кредиту необходимо:
    Размер ежемесячного платежа * кол-во месяцев и от полученного числа отнять сумму кредита
     */
    public double overPay(double mPay, int monthPeriod, double primaryCredit) {
        double overPay = (mPay * monthPeriod) - primaryCredit;
        System.out.println("---------------------------------------------------------");
        System.out.println("Сумма кредита вместе с переплатой = " + mPay * monthPeriod);
        System.out.println("---------------------------------------------------------");
        return overPay;
    }

    public double sumWithOverPay(double mPay, int monthPeriod) {
        return mPay * monthPeriod;
    }


    /*
    Общий платеж в счет основного долга сумма с учетом процентов - проценты за переплату
     */
    public double comPayCalc(double secSum, double creditPercent) {
        return  secSum - creditPercent;
    }

    //TODO:Сумма месячных процентов = ОСЗ(основная сумма) * ПС(месячная процентная ставка) / 100 %.
    //досчитать! Ежемесячный платеж - сумма процентов = платеж по кредиту!
    //Основная задолженность - платеж по кредиту = уменьшение долга!


    public double calculatePercent(double primaryCredit, double percentRate) {
        return primaryCredit * percentRate;
    }

//    public void printPaymentInfo(int monthPeriod, double primaryCredit, double yPerRate, double mPay) {
//        double sum = primaryCredit;
//        double debt = 0;
//        double pay = 0;
//        for (int i = 0; i < monthPeriod; i++) {
//            debt = sum * yPerRate / 12 /100;
//            pay = mPay - debt;
//            sum -= pay;
//            System.out.print(" Процентная составляющая: " + debt + " | ");
//            System.out.println();
//            System.out.print(" Часть на погашение долга: " + pay + " | ");
//            System.out.println();
//            System.out.print("Ежемесячный платеж: " + mPay + " |");
//
//
//        }

}
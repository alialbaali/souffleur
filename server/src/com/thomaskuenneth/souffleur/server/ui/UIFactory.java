package com.thomaskuenneth.souffleur.server.ui;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.DecimalFormat;

public class UIFactory {

    public static JFormattedTextField createIntegerField(int min, int max) {
        DecimalFormat format = new DecimalFormat();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(min);
        formatter.setMaximum(max);
        formatter.setAllowsInvalid(true);
        formatter.setCommitsOnValidEdit(true);
        return new JFormattedTextField(formatter);
    }
}
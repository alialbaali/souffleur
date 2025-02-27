package eu.thomaskuenneth.souffleur;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;
import java.awt.FlowLayout;
import java.text.DecimalFormat;

public class UIFactory {

    public static JFormattedTextField createIntegerField(int min, int max) {
        DecimalFormat format = new DecimalFormat();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(min);
        formatter.setMaximum(max);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        final JFormattedTextField textField = new JFormattedTextField(formatter);
        textField.setColumns(4);
        return textField;
    }

    public static JPanel createFlowPanel(int horizontalGap) {
        FlowLayout layout = new FlowLayout(FlowLayout.LEADING, horizontalGap, 8);
        layout.setAlignOnBaseline(true);
        return new JPanel(layout);
    }

    public static JTextField createNonEditableTextField() {
        JTextField textField = new JTextField();
        textField.setEditable(false);
        return textField;
    }
}

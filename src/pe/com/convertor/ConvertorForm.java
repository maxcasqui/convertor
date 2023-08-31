package pe.com.convertor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.Format;
import java.util.Objects;

public class ConvertorForm {
    private JPanel MainPanel;
    private JComboBox<String> cbType;
    private JComboBox<String>  cbFrom;
    private JComboBox<String>  cbTo;
    private JButton btnConvert;
    private JTextField txtInput;
    private JTextField txtOutput;

    public ConvertorForm() {
        ConvertorCurrency currency = new ConvertorCurrency();
        ConvertorTemperature temperature = new ConvertorTemperature();

        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String from = (String) cbFrom.getSelectedItem();
                String to = (String) cbTo.getSelectedItem();
                double value = 0;
                double result = 0;

                try {
                    value = Double.parseDouble(txtInput.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(btnConvert, "Debe Ingresar un Número",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                if (Objects.equals(cbType.getSelectedItem(), "Monedas")) {
                    result = currency.convert(value, from, to);
                }else{
                    result = temperature.convert(value, from, to);
                }


                txtOutput.setText(String.format("%.2f", result));

            }
        });

        ConfigureComboBoxes();
    }

    public JPanel GetMainPanel(){
        return this.MainPanel;
    }

    private void ConfigureComboBoxes(){
        cbType.addItem("Monedas");
        cbType.addItem("Temperatura");
        AddMoneyElements(cbFrom);
        AddMoneyElements(cbTo);
        cbTo.setSelectedIndex(1);

        cbType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    String item = String.valueOf(cbType.getSelectedItem());

                    cbFrom.removeAllItems();
                    cbTo.removeAllItems();

                    switch (item){
                        case "Monedas":
                        {
                            AddMoneyElements(cbFrom);
                            AddMoneyElements(cbTo);
                            cbTo.setSelectedIndex(1);
                            break;
                        }
                        case "Temperatura":
                        {
                            AddTempElements(cbFrom);
                            AddTempElements(cbTo);
                            cbTo.setSelectedIndex(1);
                            break;
                        }
                        default:
                        {
                            JOptionPane.showMessageDialog(btnConvert,"Internal Error", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
    }

    private void AddMoneyElements(JComboBox<String> comboBox){
        comboBox.addItem("Soles");
        comboBox.addItem("Dolares");
        comboBox.addItem("Euros");
        comboBox.addItem("Libras Esterlinas");
        comboBox.addItem("Yen Japones");
        comboBox.addItem("Won Sur Coreano");
    }

    private void AddTempElements(JComboBox<String> comboBox){
        comboBox.addItem("Celsius");
        comboBox.addItem("Fahrenheit");
        comboBox.addItem("Kelvin");
    }
}

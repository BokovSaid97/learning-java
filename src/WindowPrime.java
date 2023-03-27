import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class WindowPrime extends JFrame{
    private JLabel first = new JLabel("C");
    private JTextField pole = new JTextField("",15);
    private JLabel end = new JLabel("По");
    private JTextField pole2 = new JTextField("",15);
    private Button button = new Button("Вычислить");
    private JLabel  prost = new JLabel("Простые числа  ");
    private JTextField pole3 = new JTextField("",55);

    private JLabel fife_prost = new JLabel("Простые числа с суммой цифр равной 5  ");
    private JTextField pole4 = new JTextField("", 40);

    private JLabel summa_number = new JLabel("Сумма цифр всех простых чисел  ");
    private JTextField pole5 = new JTextField("", 44);

    public WindowPrime() {
        super("forms");
        super.setBounds(400,300,700,200);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new MigLayout("insets 10"));

        container.add(first,"gap");
        container.add(pole,"gap 1, span 2");
        container.add(end,"gap");
        container.add(pole2,"gap, span 2");

        container.add(button,"gap, wrap");
        container.add(prost,"gap 1 1 15 1, split 2, span 7");
        container.add(pole3,"gap 1 1 15 1, wrap");

        container.add(fife_prost,"gap 1, split 2, span 7");
        container.add(pole4,"gap 1,pad 0 0 0 2, wrap");

        container.add(summa_number,"gap 1, split 2, span 7");
        container.add(pole5,"gap 1,pad 0 0 0 4");

        ActionListener actionListener = new TestActionListener();
        button.addActionListener(actionListener);
    }

    public class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            PrimeNumberCalculate calc = new PrimeNumberCalculate();
            if (calc.validator(pole.getText(), pole2.getText()) == 0) {
                List<Integer> primes = new ArrayList<>();
                primes = calc.prime(pole.getText(), pole2.getText());
                pole3.setText(calc.getPrimeString(primes));
                pole4.setText(calc.getPrimeSumEqualFive(primes));
                pole5.setText(calc.getPrimeFullySumma(primes));
            } else {
                JOptionPane.showMessageDialog(null,"Некорректный ввод!");
            }
        }
    }

}

package ru.kpfu.itis.forms;

import ru.kpfu.itis.repo.ProductRepo;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * GUI с таблицей продуктов
 */

public class ProductListForm extends JFrame {

    public JPanel getPanel() {

        JPanel panel = new JPanel(new GridLayout(1, 1));

        String[] columns = new String[]{"name", "price", "weight", "manufacturer", "category"};
        String[][] data = ProductRepo.getTable();

        JTable table = new JTable(data, columns);

        table.getColumnModel().getColumn(0).setPreferredWidth(70);
        for (int i = 1; i < columns.length; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(50);
        }
        table.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane);
        panel.setBorder(new TitledBorder("Products List"));


        return panel;
    }

}

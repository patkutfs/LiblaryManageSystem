import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BookManager extends JFrame {

    private Books books = new Books();

    public BookManager() {
        setTitle("Book Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(1, 2));

        JPanel leftPanel = new JPanel(new GridBagLayout());
        JLabel bookManagementLabel = new JLabel("Book Management");
        bookManagementLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        leftPanel.add(bookManagementLabel);

        books.reader();

        String[] columns = {"Author", "Pages", "Title"};
        Object[][] tableData = convertListsToTableData();
        DefaultTableModel model = new DefaultTableModel(tableData, columns);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(leftPanel);
        add(scrollPane);

        setVisible(true);
    }

    private Object[][] convertListsToTableData() {
        int rowCount = books.authorData.size();
        Object[][] data = new Object[rowCount][3];
        for (int i = 0; i < rowCount; i++) {
            data[i][0] = books.authorData.get(i);
            data[i][1] = (i < books.pagesData.size()) ? books.pagesData.get(i) : null;
            data[i][2] = (i < books.titlesData.size()) ? books.titlesData.get(i) : null;
        }
        return data;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BookManager::new);
    }
}

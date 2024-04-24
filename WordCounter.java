import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class WordCounter extends JFrame {
    private JTextArea textArea;
    private JLabel wordCountLabel;

    public WordCounter() {
        setTitle("Word Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Create components
        textArea = new JTextArea();
        wordCountLabel = new JLabel("Word Count: 0");

        // Add document listener to JTextArea to count words
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateWordCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateWordCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateWordCount();
            }
        });

        // Add components to the frame
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(wordCountLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void updateWordCount() {
        String text = textArea.getText();
        int wordCount = text.trim().isEmpty() ? 0 : text.split("\\s+").length;
        wordCountLabel.setText("Word Count: " + wordCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WordCounter::new);
    }
}



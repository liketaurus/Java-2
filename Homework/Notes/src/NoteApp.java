
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Note implements Serializable {

    private String title;
    private String text;

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return title;
    }
}

public class NoteApp extends JFrame {

    private List<Note> notes;
    private JTextArea textArea;
    private JTextField titleField;
    private JList<Note> noteList;

    public NoteApp() {
        notes = new ArrayList<>();
        initializeUI();
    }

    private void initializeUI() {
        titleField = new JTextField();
        textArea = new JTextArea();
        JButton addButton = new JButton("Додати нотатку");
        noteList = new JList<>();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNote();
            }
        });

        noteList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                displaySelectedNoteContent(noteList.getSelectedValue());
            }
        });

        JScrollPane noteScrollPane = new JScrollPane(noteList);
        JScrollPane textScrollPane = new JScrollPane(textArea);

        JPanel inputPanel = new JPanel(new BorderLayout());
        JPanel input1 = new JPanel(new GridLayout(2, 1));
        input1.add(new JLabel("Заголовок: "));
        input1.add(titleField);
        inputPanel.add(input1, BorderLayout.NORTH);
        JPanel input2 = new JPanel();
        input2.setLayout(new BoxLayout(input2,BoxLayout.PAGE_AXIS));
        input2.add(new JLabel("Текст: "));
        input2.add(textArea);
        inputPanel.add(input2, BorderLayout.CENTER);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, noteScrollPane, inputPanel);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150); // Початкова ширина області списку нотаток

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(addButton, BorderLayout.SOUTH);
        rightPanel.add(splitPane, BorderLayout.CENTER);

        add(rightPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setTitle("Note App");
    }

    private void addNote() {
        String title = titleField.getText();
        String text = textArea.getText();
        Note note = new Note(title, text);
        notes.add(note);
        refreshNoteList();
        saveNotesToFile();
        clearInputFields();
    }

    private void displaySelectedNoteContent(Note selectedNote) {
        if (selectedNote != null) {
            titleField.setText(selectedNote.getTitle());
            textArea.setText(selectedNote.getText());
        }
    }

    private void refreshNoteList() {
        noteList.setListData(notes.toArray(new Note[0]));
    }

    private void saveNotesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("notes.ser"))) {
            oos.writeObject(notes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadNotesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("notes.ser"))) {
            notes = (List<Note>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // If the file does not exist or cannot be read, ignore and continue with an empty note list.
        }
        refreshNoteList();
    }

    private void clearInputFields() {
        titleField.setText("");
        textArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NoteApp noteApp = new NoteApp();
            noteApp.loadNotesFromFile();
            noteApp.setVisible(true);
        });
    }
}

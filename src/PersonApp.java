//Mary Czelusniak
//Advanced Java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Vector;

public class PersonApp extends JFrame implements ActionListener {

    JMenuBar bar;
    JMenu fileMenu;
    JMenu fileMenu_new;

    JMenuItem fileMenu_open;
    JFileChooser fileChooser;
    FileInputStream file;
    FileOutputStream fileSave;
    ObjectInputStream in;
    ObjectOutputStream out;



    JMenuItem fileMenu_save;
    JMenuItem fileMenu_saveAs;

    JMenuItem fileMenu_exit;
    JMenuItem occc, registered,person;

    JMenu help;
    JMenuItem help_help;
    //JOptionPane helpOption;

    JButton delete, edit, submit;
    JTextField firstName, lastName, govID, studentId;

    boolean editSwitch = false;

    Vector<Person> persons;
    JComboBox dropDown;
    //JLabel displayPerson;

    JPanel top;
    JPanel title;
    JPanel bottom;
    JLabel titleLabel;
    JTextArea object;


    public PersonApp(){
        super("Person Application");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Person Application");
        titleLabel.setBackground(Color.lightGray);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setOpaque(true);

        title = new JPanel();
        title.setBackground(Color.lightGray);
        title.add(titleLabel);
        //add(title, BorderLayout.SOUTH);



        //Drop down menu
        //TextFields and submit button when prompted for edit
        //Same Panel
        top = new JPanel(new FlowLayout());

//        Person test = new Person("Here Goes the First Name","Here Goes the Last Name");
//        RegisteredPerson test2 = new RegisteredPerson(test,"Government ID");
//        OCCCPerson test3 = new OCCCPerson(test2,"Student ID");

        persons = new Vector<Person>();

       // persons.add(test);

        dropDown = new JComboBox(persons);
        dropDown.setPrototypeDisplayValue("Here Goes the First NameHere Goes the Last NameHere Goes the Last Name");
        firstName = new JTextField("Here Goes the First Name",14);
        firstName.setEnabled(false);
        firstName.setVisible(true);
        lastName = new JTextField("Here Goes the Last Name",14);
        lastName.setEnabled(false);
        lastName.setVisible(true);



        object = new JTextArea();

        object.setBackground(Color.lightGray);
        object.setForeground(Color.BLACK);
        object.setFont(new Font("Times New Roman", Font.BOLD, 20));
        object.setLineWrap(true);
        object.setWrapStyleWord(true);
        object.setEditable(false);
        object.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        //object.setHorizontalAlignment(JTextArea.CENTER);
        object.setOpaque(true);

        bottom = new JPanel(new BorderLayout());
        //bottom.setBackground(Color.lightGray);
        bottom.add(object);
        //add(bottom, BorderLayout.CENTER);





        //Only when creating because GovID and StudentID had no setters in the original assignment
        govID = new JTextField("Government ID", 10);
        govID.setEnabled(false);
        govID.setVisible(true);

        studentId = new JTextField("Student ID", 6);
        studentId.setEnabled(false);
        studentId.setVisible(true);
        submit = new JButton("Submit");

        delete = new JButton("Delete");
        edit = new JButton("Edit");





        //Menu bars
        occc = new JMenuItem("OCCCPerson");
        registered = new JMenuItem("RegisteredPerson");
        person = new JMenuItem("Person");

        bar = new JMenuBar();
        fileMenu = new JMenu("File");


        fileMenu_new = new JMenu("New");
        fileMenu_new.add(occc);
        fileMenu_new.add(registered);
        fileMenu_new.add(person);
        fileMenu.add(fileMenu_new);



        fileMenu_open = new JMenuItem("Open");
        fileMenu_save = new JMenuItem("Save");
        fileMenu_saveAs = new JMenuItem("Save As");
        fileMenu_exit = new JMenuItem("Exit");
        help = new JMenu("Help");
        help_help = new JMenuItem ("Help");

        //Adding menu
        fileMenu.add(fileMenu_new);
        fileMenu.add(fileMenu_open);
        fileMenu.add(fileMenu_save);
        fileMenu.add(fileMenu_saveAs);
        fileMenu.add(fileMenu_exit);
        help.add(help_help);
        bar.add(help);
        bar.add(fileMenu);


        //Interaction for menu
        fileMenu_new.addActionListener(this);
        fileMenu_open.addActionListener(this);
        fileMenu_save.addActionListener(this);
        fileMenu_saveAs.addActionListener(this);
        fileMenu_exit.addActionListener(this);
        help_help.addActionListener(this);

        occc.addActionListener(this);
        registered.addActionListener(this);
        person.addActionListener(this);


        //Interaction for delete,edit and submit
        delete.addActionListener(this);
        edit.addActionListener(this);
        submit.addActionListener(this);
        dropDown.addActionListener(this);

        //TextField edit
        lastName.addActionListener(this);
        firstName.addActionListener(this);



        //Adding to frame
        top.add(submit);
        top.add(delete);
        top.add(edit);
        top.add(dropDown);
        top.add(firstName);
        top.add(lastName);
        top.add(govID);
        top.add(studentId);
        top.add(submit);
       // top.add(object);


//        add(submit);
//        add(dropDown);
//        add(edit);
//        add(firstName);
//        add(lastName);
//        add(govID);
//        add(studentId);
        add(top, BorderLayout.CENTER);
        add(bottom, BorderLayout.NORTH);
        add(title, BorderLayout.SOUTH);
        setJMenuBar(bar);


        setLocationRelativeTo(null);

        setVisible(true);





        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                exitMenuDemo();
            }
        });

    }

    public void exitMenuDemo(){

        dispose();
        System.exit(0);
    }



    public static void main (String[] args){
        PersonApp a = new PersonApp();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = dropDown.getSelectedIndex();

        if(e.getSource()== dropDown){

            object.setText(persons.get(dropDown.getSelectedIndex()).toString());
        }




        if(e.getSource() == help_help){
            JOptionPane.showMessageDialog(null,"This is the Help option", "Help",1);
        }

        if(e.getSource() == delete){
            if( !(i < 0) ) {
                persons.remove(i);
                firstName.setEnabled(false);
                lastName.setEnabled(false);
                studentId.setEnabled(false);
                govID.setEnabled(false);
            }
            //dropDown.remove(i);
        }

        if(e.getSource() == edit){
            //System.out.println(i);
            if( !(i < 0) ) {
                firstName.setText(persons.get(i).getFirstName());
                lastName.setText(persons.get(i).getLastName());
                firstName.setEnabled(true);
                lastName.setEnabled(true);

                editSwitch = true;
            }

        }


        if(e.getSource()==submit){
            if(editSwitch) {
                persons.get(i).setFirstName(firstName.getText());
                persons.get(i).setLastName(lastName.getText());
                firstName.setEnabled(false);
                lastName.setEnabled(false);
                editSwitch = false;

                firstName.setText("Here Goes the First Name");
                lastName.setText("Here Goes the Last Name");

            }
            else if(studentId.isEnabled() && govID.isEnabled() && !editSwitch){

                persons.add( new OCCCPerson((new RegisteredPerson( firstName.getText(),lastName.getText(),govID.getText())),studentId.getText()));
                firstName.setEnabled(false);
                lastName.setEnabled(false);
                studentId.setEnabled(false);
                govID.setEnabled(false);
                firstName.setText("Here Goes the First Name");
                lastName.setText("Here Goes the Last Name");
                govID.setText("Government ID");
                studentId.setText("Student ID");
            }
            else if(!studentId.isEnabled() && !editSwitch && govID.isEnabled()){

                persons.add(new RegisteredPerson(firstName.getText(),lastName.getText(),govID.getText()));
                studentId.setEnabled(false);
                firstName.setEnabled(false);
                lastName.setEnabled(false);
                govID.setEnabled(false);
                firstName.setText("Here Goes the First Name");
                lastName.setText("Here Goes the Last Name");
                govID.setText("Government ID");
            }
            else if(!govID.isEnabled() && !editSwitch && !studentId.isEnabled()){

                persons.add(new Person (firstName.getText(),lastName.getText()));
                studentId.setEnabled(false);
                govID.setEnabled(false);
                firstName.setEnabled(false);
                lastName.setEnabled(false);
                firstName.setText("Here Goes the First Name");
                lastName.setText("Here Goes the Last Name");
            }

        }


        if(e.getSource() == fileMenu_exit){
            exitMenuDemo();
        }

        if(e.getSource() == fileMenu_open){
            fileChooser = new JFileChooser();

            int response = fileChooser.showOpenDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                try {
                    file = new FileInputStream(fileChooser.getSelectedFile().getAbsolutePath());
                    in = new ObjectInputStream(new BufferedInputStream(file));

                    persons.clear();
                    Vector<Person> fileV = (Vector<Person>) in.readObject();
                    for(int x = 0; x < fileV.size(); x++){
                        persons.add(fileV.get(x));
                    }


                } catch (ClassNotFoundException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        }


        if(e.getSource() ==fileMenu_save){
            try {
                String filename = JOptionPane.showInputDialog("Please input file name");

                fileSave = new FileOutputStream(filename);
                out = new ObjectOutputStream(fileSave);

                out.writeObject(persons);



            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


        if(e.getSource() == fileMenu_saveAs){
            fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int result = fileChooser.showSaveDialog(null);
            if(result == JFileChooser.APPROVE_OPTION){

                try {
                    // String content = textContent.getText();
                    File file = fileChooser.getSelectedFile();
                    file.setReadable(true);
                    fileSave = new FileOutputStream(file.getAbsolutePath() +"/"+ "SavedAsFile");
                    out = new ObjectOutputStream(fileSave);

                    out.writeObject(persons);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }

        //fileMenu_new
        if(e.getSource() == occc){
            firstName.setEnabled(true);
            lastName.setEnabled(true);
            studentId.setEnabled(true);
            govID.setEnabled(true);

        }
        if(e.getSource() == registered){
            firstName.setEnabled(true);
            lastName.setEnabled(true);
            govID.setEnabled(true);

            studentId.setEnabled(false);



        }
        if(e.getSource() == person){
            firstName.setEnabled(true);
            lastName.setEnabled(true);

            studentId.setEnabled(false);
            govID.setEnabled(false);

        }

    }
}

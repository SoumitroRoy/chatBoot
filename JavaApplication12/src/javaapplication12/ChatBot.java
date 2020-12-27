package javaapplication12;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Color;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ChatBot extends JFrame implements KeyListener {

    JPanel p = new JPanel();
    JTextArea dialog = new JTextArea(20, 50);
    JTextArea input = new JTextArea(2, 50);
    JScrollPane scroll = new JScrollPane(
            dialog,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
    );

    String[][] chatBot = {
        //standard greetings
        {"hi", "hello", "hola", "ola", "howdy"},
        {"hi", "hello", "hey"},
        
        //question greetings
        {"how are you", "how r you", "how r u", "how are u"},
        {"good", "doing well"},
        
        //yes
        {"yes"},
        {"no", "NO", "NO!!!!!!!"},
        
        //project talking 
        {"you are my project michael","I made you micheal","you r my project"},
        {"I think you made me well","well done"},  
        
        //thanks giving 
        {"thanks","thank you","thx"},
        {"welcome","mention not plz"},
        
        //encuraging someone
        {"I think i can't do that","i will fail anyway","do u think i can do it"},
        {"don't stop trying","you should try harder","keep going, u not gono fail"},
        
        //stop bdy shaming
        {"he are ugly","she is fat","she is ugly","they are short","he look a tower"},
        {"Warning!!! stop bdy shaming,plz"},
        
        //default
        { "you're bad", "noob",
         "(michael is unavailable, due to LOL)","come again plz","didn't get you"}
         
    };

    String[][] verbs = {
        {"is", "'re "}, {"was", "'re"}, {"think", " think"}, {"s", "'re"},
        {"'re", "'re"},{"are","'re"}//,{"are"," am"},{"you","I"}

    };

    public static void main(String[] args) {
        new ChatBot();
    }

    public ChatBot() {
        super("Welcome to chatting world!!!");
        setSize(600, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        dialog.setEditable(false);
        input.addKeyListener(this);

        p.add(scroll);
        p.add(input);
        p.setBackground(new Color(255, 200, 0));
        add(p);

        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            input.setEditable(false);
            //-----grab quote-----------
            String quote = input.getText();
            input.setText("");
            addText("-->You:\t" + quote);
            quote = quote.trim();
            while (quote.charAt(quote.length() - 1) == '!'
                    || quote.charAt(quote.length() - 1) == '.'
                    || quote.charAt(quote.length() - 1) == '?') {
                quote = quote.substring(0, quote.length() - 1);
            }
            quote = quote.trim();
            byte response = 0;
            /*
			0:we're searching through chatBot[][] for matches
			1:we didn't find anything
			2:we did find something
             */
            //-----check for matches----
            int j = 0;//which group we're checking
            while (response == 0) {
                if (inArray(quote.toLowerCase(), chatBot[j * 2])) {
                    response = 2;
                    int r = (int) Math.floor(Math.random() * chatBot[(j * 2) + 1].length);
                    addText("\n-->Michael:\t" + chatBot[(j * 2) + 1][r]);
                }
                j++;
                if (j * 2 == chatBot.length - 1 && response == 0) {
                    response = 1;
                }
            }
            //------try counter-------
            if (response == 1) {
                String quoteWords[] = quote.split("[ ']");
                int c = counter(quoteWords);
                if (c != -1) {
                    String ext;
                    ext = quote.split(verbs[c][0])[1];
                    addText("\n-->Michael:\tYou" + verbs[c][1] + ext);
                    response = 2;
                }

            }
            //-----default--------------
            if (response == 1) {
                int r = (int) Math.floor(Math.random() * chatBot[chatBot.length - 1].length);
                addText("\n-->Michael:\t" + chatBot[chatBot.length - 1][r]);
            }
            addText("\n");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            input.setEditable(true);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void addText(String str) {
        dialog.setText(dialog.getText() + str);
    }

    public boolean inArray(String in, String[] str) {
        boolean match = false;
        for (String str1 : str) {
            if (str1.equals(in)) {
                match = true;
            }
        }
        return match;
    }

    public int counter(String str[]) {
        int verbID = -1;

        for (String str1 : str) {
            for (int j = 0; j < verbs.length; j++) {
                if (str1.equals(verbs[j][0])) {
                    verbID = j;
                }
            }
        }
        return verbID;
    }
}

 
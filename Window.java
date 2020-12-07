 import java.awt.Color;
 import java.awt.Component;
 import java.awt.Font;
 import java.awt.LayoutManager;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.util.Random;
 import javax.swing.ImageIcon;
 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JOptionPane;

 public class Window
   extends JFrame
   implements ActionListener
 {
   JButton paper = new JButton("PAPER");
   JButton rock = new JButton("ROCK");
   JButton scissors = new JButton("SCISSORS");
   JLabel computerChoice = new JLabel();
   JLabel playerChoice = new JLabel();
   JLabel scoresPlayer = new JLabel();
   JLabel scoresComputer = new JLabel();
   int pktComputer = 0;
   int pktPlayer = 0;
   
   JLabel picture = new JLabel();

   enum RPS
   {
     PAPER,
     ROCK,
     SCISSORS;
   }
   
   Random random = new Random();
   
   public Window() {
     setSize(1000, 500);
     setTitle("PAPER, ROCK, SCISSORS");
     setLayout((LayoutManager)null);
     setLocationRelativeTo((Component)null);
     
     this.paper.setBounds(100, 350, 200, 100);
     add(this.paper);
     this.paper.setFont(new Font("Helvetica Neue", 0, 30));
     this.paper.addActionListener(this);
     
     this.rock.setBounds(400, 350, 200, 100);
     add(this.rock);
     this.rock.setFont(new Font("SansSerif", 0, 30));
     this.rock.addActionListener(this);
     
     this.scissors.setBounds(700, 350, 200, 100);
     add(this.scissors);
     this.scissors.setFont(new Font("SansSerif", 0, 30));
     this.scissors.addActionListener(this);
     
     this.computerChoice.setBounds(200, 100, 800, 200);
     this.computerChoice.setFont(new Font("SansSerif", 1, 40));
     this.computerChoice.setForeground(Color.cyan);
     add(this.computerChoice);
     
     this.playerChoice.setBounds(200, 150, 800, 200);
     this.playerChoice.setFont(new Font("SansSerif", 1, 20));
     this.playerChoice.setForeground(Color.GREEN);
     add(this.playerChoice);
     
     this.scoresPlayer.setBounds(200, 50, 800, 200);
     this.scoresPlayer.setFont(new Font("SansSerif", 1, 20));
     this.scoresPlayer.setForeground(Color.white);
     add(this.scoresPlayer);
     
     this.scoresComputer.setBounds(200, 25, 800, 200);
     this.scoresComputer.setFont(new Font("SansSerif", 1, 20));
     this.scoresComputer.setForeground(Color.white);
     add(this.scoresComputer);
     
     this.picture.setBounds(0, 0, 1000, 500);
     add(this.picture);
     this.picture.setIcon(new ImageIcon(getClass().getResource("club.jpg")));
   }
   
   public static void main(String[] args) {
    Window window = new Window();
    window.setDefaultCloseOperation(3);
    window.setVisible(true);
    window.setResizable(false);
   }

   public void actionPerformed(ActionEvent e) {
     Object source = e.getSource();

     int randomInt = this.random.nextInt(3);
     
     if (source == this.paper &&
       randomInt < (RPS.values()).length) {
       this.playerChoice.setText("YOUR CHOICE: PAPER");
       this.computerChoice.setText("COMPUTER'S CHOICE: " + RPS.values()[randomInt]);
       if (randomInt == 0)
         this.scoresComputer.setText("COMPUTER: " + this.pktComputer);
       this.scoresPlayer.setText("PLAYER: " + this.pktPlayer);
       if (randomInt == 1)
         this.pktPlayer++;
       this.scoresComputer.setText("COMPUTER: " + this.pktComputer);
       this.scoresPlayer.setText("PLAYER: " + this.pktPlayer);
       if (randomInt == 2)
         this.pktComputer++;
       this.scoresComputer.setText("COMPUTER: " + this.pktComputer);
       this.scoresPlayer.setText("PLAYER: " + this.pktPlayer);
     } 
     
     if (source == this.rock &&
       randomInt < (RPS.values()).length) {
       this.playerChoice.setText("YOUR CHOICE: ROCK");
       this.computerChoice.setText("COMPUTER'S CHOICE: " + RPS.values()[randomInt]);
       if (randomInt == 0)
         this.pktComputer++;
       this.scoresComputer.setText("COMPUTER: " + this.pktComputer);
       this.scoresPlayer.setText("GRACZ: " + this.pktPlayer);
       if (randomInt == 1)
         this.scoresComputer.setText("COMPUTER: " + this.pktComputer);
       this.scoresPlayer.setText("PLAYER: " + this.pktPlayer);
       if (randomInt == 2)
         this.pktPlayer++;
       this.scoresComputer.setText("COMPUTER: " + this.pktComputer);
       this.scoresPlayer.setText("PLAYER: " + this.pktPlayer);
     } 
     
     if (source == this.scissors &&
       randomInt < (RPS.values()).length) {
       this.playerChoice.setText("YOUR CHOICE: SCISSORS");
       this.computerChoice.setText("COMPUTER'S CHOICE: " + RPS.values()[randomInt]);
       if (randomInt == 0)
         this.pktPlayer++;
       this.scoresComputer.setText("COMPUTER: " + this.pktComputer);
       this.scoresPlayer.setText("PLAYER: " + this.pktPlayer);
       if (randomInt == 1)
         this.pktComputer++;
       this.scoresComputer.setText("COMPUTER: " + this.pktComputer);
       this.scoresPlayer.setText("PLAYER: " + this.pktPlayer);
       if (randomInt == 2)
         this.scoresComputer.setText("COMPUTER: " + this.pktComputer);
       this.scoresPlayer.setText("PLAYER: " + this.pktPlayer);
     }

     if (this.pktComputer == 3) {
       this.scoresComputer.setText("COMPUTER WIN");
       this.pktComputer = 0;
       this.pktPlayer = 0;
       JOptionPane.showMessageDialog(null, "Computer win!");
     }

     if (this.pktPlayer == 3) {
       this.scoresPlayer.setText("PLAYER WIN");
       this.pktPlayer = 0;
       this.pktComputer = 0;
       JOptionPane.showMessageDialog(null, "Player win!");
     }
   }
 }

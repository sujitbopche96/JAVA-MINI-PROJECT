Name :- Sujit Bopche 

Roll no. :- CT-76


Batch :- A4


Branch :- Computer Technology 


Regestration No. :- 24030117


Java Chatting Application (Client–Server)
A simple desktop-based Chatting Application built using Java Swing, AWT, and Socket Programming.
 This project demonstrates how a client and server communicate over a network using TCP/UDP sockets.
 It is ideal for beginners learning Java network programming and the fundamentals of the client-server model.

📘 Introduction
    This project consists of a Chat Server and Chat Client, implemented using:
    java.net — for socket programming
    java.io — for handling input/output streams
    javax.swing & java.awt — for graphical user interfaces


The application allows two systems (or the same system using loopback address) to exchange text messages over a network.
Chatting applications help bring people and ideas together despite geographical barriers.
Our system demonstrates the essential principles behind a multi-client chat server, though this version uses a simple single-server, single-client model.

🎯 Main Objective
  The main aim of this project is to:
  Implement a simple chat system using Java sockets
  Allow real-time communication between Server and Client
  Demonstrate core concepts like
  Socket connection
  Data transmission
  Java Swing UI
  Client–Server architecture
  Run the project using Java SE and loopback address (127.0.0.1)


The project includes two modules:
  Server
  Client



🖥️ System Overview
🔵 Server Module
Waits for client connection requests
Accepts valid client connections
Allows message exchange with connected client
Remains continuously active even if clients disconnect


Uses:
  ServerSocket (Listening port)
  Socket (Connection handling)


🟢 Client Module
    Connects to the server using hostname and port number
    Sends requests/messages to the server
    Displays received messages
    Must start after the server



🧰 Requirements
    ✔ Software Requirements
    Java SE Development Kit (JDK)
    Swing/AWT (built-in with JDK)
    Basic knowledge of:
    Java programming
    Socket programming (TCP/UDP)


✔ User Interface
    The application uses AWT and Swing for building graphical components such as:
    Textboxes
    Chat area
    Send button
    Message display panel



⚙️ Operational Flow
    Start the Server Application
    The server listens on a specific port
    Start the Client Application
    Client connects to the server
    User types a message
    Message is:
    Encoded
    Sent over the network
    Decoded on the other side
    Displayed in the chat window



🖼️ Screens Included
  Server Screen
  
  Client Screen
  
  Client–Server Chat Window




📦 Project Structure
/ChatApplication
│
├── Server.java
├── Client.java
├── README.md
└── /images (optional)


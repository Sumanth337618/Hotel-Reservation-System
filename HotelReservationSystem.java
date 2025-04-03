// Import necessary packages for Swing, AWT, and event handling
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Main class extending JFrame for the Hotel Reservation System
public class HotelReservationSystem extends JFrame {

    // Declare a CardLayout to switch between different dashboard panels
    private CardLayout cardLayout;
    
    // Declare the main container panel that uses CardLayout
    private JPanel cardPanel;

    // Constructor for the HotelReservationSystem class
    public HotelReservationSystem() {
        // Initialize the main frame settings (title, size, etc.)
        initializeFrame();
        
        // Set up the menu bar with role-based items
        initializeMenuBar();
        
        // Initialize all dashboard panels and add them to the card panel
        initializeCardPanels();
    }
    
    // Method to initialize the main frame properties
    private void initializeFrame() {
        // Set the title of the application window
        setTitle("Hotel Reservation System");
        
        // Specify the operation that will happen by default when the user closes the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set the size of the application window
        setSize(1000, 700);
        
        // Set the layout manager for the frame
        setLayout(new BorderLayout());
        
        // Center the frame on the screen
        setLocationRelativeTo(null);
    }
    
    // Method to set up the menu bar at the top of the window
    private void initializeMenuBar() {
        // Create a new JMenuBar instance
        JMenuBar menuBar = new JMenuBar();
        
        // Create menu items for each user role
        JMenuItem adminMenuItem = new JMenuItem("Admin");
        JMenuItem receptionistMenuItem = new JMenuItem("Receptionist");
        JMenuItem roomManagerMenuItem = new JMenuItem("Room Manager");
        JMenuItem paymentManagerMenuItem = new JMenuItem("Payment Manager");
        
        // Add an action listener to the Admin menu item to display the Admin dashboard panel
        adminMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "AdminDashboardPanel");
            }
        });
        
        // Add an action listener to the Receptionist menu item to display the Receptionist dashboard panel
        receptionistMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "ReceptionistDashboardPanel");
            }
        });
        
        // Add an action listener to the Room Manager menu item to display the Room Manager dashboard panel
        roomManagerMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "RoomManagerDashboardPanel");
            }
        });
        
        // Add an action listener to the Payment Manager menu item to display the Payment Manager dashboard panel
        paymentManagerMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "PaymentManagerDashboardPanel");
            }
        });
        
        // Add all menu items to the menu bar
        menuBar.add(adminMenuItem);
        menuBar.add(receptionistMenuItem);
        menuBar.add(roomManagerMenuItem);
        menuBar.add(paymentManagerMenuItem);
        
        // Set the menu bar for this frame
        setJMenuBar(menuBar);
    }
    
    // Method to initialize the card panels for different dashboards
    private void initializeCardPanels() {
        // Instantiate the CardLayout for the container panel
        cardLayout = new CardLayout();
        
        // Create the main panel using the CardLayout
        cardPanel = new JPanel(cardLayout);
        
        // Create individual panels for each dashboard
        JPanel adminDashboardPanel = new AdminDashboardPanel();
        JPanel receptionistDashboardPanel = new ReceptionistDashboardPanel();
        JPanel roomManagerDashboardPanel = new RoomManagerDashboardPanel();
        JPanel paymentManagerDashboardPanel = new PaymentManagerDashboardPanel();
        
        // Add each dashboard panel to the card panel with a unique identifier
        cardPanel.add(adminDashboardPanel, "AdminDashboardPanel");
        cardPanel.add(receptionistDashboardPanel, "ReceptionistDashboardPanel");
        cardPanel.add(roomManagerDashboardPanel, "RoomManagerDashboardPanel");
        cardPanel.add(paymentManagerDashboardPanel, "PaymentManagerDashboardPanel");
        
        // Add the card panel to the center of the main frame
        add(cardPanel, BorderLayout.CENTER);
        
        // Optionally show a default dashboard (here we show Admin)
        cardLayout.show(cardPanel, "AdminDashboardPanel");
    }
    
    // Inner class for the Administrator Dashboard Panel
    private class AdminDashboardPanel extends JPanel {
        // Declare CardLayout to switch between login and main panels for Admin
        private CardLayout adminCardLayout;
        private JPanel adminCardPanel;
        
        // Constructor for the Administrator Dashboard Panel
        public AdminDashboardPanel() {
            // Set the layout for the AdminDashboardPanel
            setLayout(new BorderLayout());
            
            // Initialize the CardLayout for Admin panels
            adminCardLayout = new CardLayout();
            
            // Create a panel that uses the CardLayout for Admin functionalities
            adminCardPanel = new JPanel(adminCardLayout);
            
            // Create the Admin login panel and the Admin main panel
            JPanel adminLoginPanel = createAdminLoginPanel();
            JPanel adminMainPanel = createAdminMainPanel();
            
            // Add the panels to the adminCardPanel with unique identifiers
            adminCardPanel.add(adminLoginPanel, "AdminLogin");
            adminCardPanel.add(adminMainPanel, "AdminMain");
            
            // Add the adminCardPanel to this dashboard panel
            add(adminCardPanel, BorderLayout.CENTER);
            
            // Start by showing the Admin login panel
            adminCardLayout.show(adminCardPanel, "AdminLogin");
        }
        
        // Method to create the Admin Login Panel
        private JPanel createAdminLoginPanel() {
            // Create a panel with GridBagLayout for the login form
            JPanel loginPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            
            // Set common constraints for the layout
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            
            // Create a label for username
            JLabel usernameLabel = new JLabel("Username:");
            // Position the username label
            gbc.gridx = 0;
            gbc.gridy = 0;
            loginPanel.add(usernameLabel, gbc);
            
            // Create a text field for entering username
            JTextField usernameField = new JTextField(20);
            // Position the username field
            gbc.gridx = 1;
            gbc.gridy = 0;
            loginPanel.add(usernameField, gbc);
            
            // Create a label for password
            JLabel passwordLabel = new JLabel("Password:");
            // Position the password label
            gbc.gridx = 0;
            gbc.gridy = 1;
            loginPanel.add(passwordLabel, gbc);
            
            // Create a password field for entering password
            JPasswordField passwordField = new JPasswordField(20);
            // Position the password field
            gbc.gridx = 1;
            gbc.gridy = 1;
            loginPanel.add(passwordField, gbc);
            
            // Create a button for login
            JButton loginButton = new JButton("Login");
            // Position the login button
            gbc.gridx = 1;
            gbc.gridy = 2;
            loginPanel.add(loginButton, gbc);
            
            // Add an action listener to the login button for authentication
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // In a real system, replace this with authentication using a database connection
                    String username = usernameField.getText().trim();
                    String password = new String(passwordField.getPassword()).trim();
                    
                    // Dummy check: username and password must both be "admin" for successful login
                    if(username.equals("admin") && password.equals("admin")) {
                        // Switch to the main admin panel on successful login
                        adminCardLayout.show(adminCardPanel, "AdminMain");
                    } else {
                        // Display an error message on failed login
                        JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            
            // Return the constructed Admin login panel
            return loginPanel;
        }
        
        // Method to create the Admin Main Panel with actual functionalities
        private JPanel createAdminMainPanel() {
            // Create a panel with BorderLayout for the main Admin functionalities
            JPanel mainPanel = new JPanel(new BorderLayout());
            
            // Create a label for the Admin Dashboard header
            JLabel headerLabel = new JLabel("Administrator Dashboard", SwingConstants.CENTER);
            headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
            mainPanel.add(headerLabel, BorderLayout.NORTH);
            
            // Create a panel for the buttons representing different functionalities
            JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 20, 20));
            
            // Create a button for creating management users
            JButton createUserButton = new JButton("Create Management User");
            // Create a button for deleting management users
            JButton deleteUserButton = new JButton("Delete Management User");
            // Create a button for generating reports
            JButton generateReportButton = new JButton("Generate Reports");
            // Create a button for logging out
            JButton logoutButton = new JButton("Logout");
            
            // Add action listener to the Create User button
            createUserButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Call the method to create a new management user
                    createManagementUser();
                }
            });
            
            // Add action listener to the Delete User button
            deleteUserButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Call the method to delete a management user
                    deleteManagementUser();
                }
            });
            
            // Add action listener to the Generate Reports button
            generateReportButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Call the method to generate comprehensive reports
                    generateAdminReports();
                }
            });
            
            // Add action listener to the Logout button
            logoutButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Switch back to the login panel when logging out
                    adminCardLayout.show(adminCardPanel, "AdminLogin");
                }
            });
            
            // Add the buttons to the button panel
            buttonPanel.add(createUserButton);
            buttonPanel.add(deleteUserButton);
            buttonPanel.add(generateReportButton);
            buttonPanel.add(logoutButton);
            
            // Add the button panel to the center of the main panel
            mainPanel.add(buttonPanel, BorderLayout.CENTER);
            
            // Return the constructed Admin main panel
            return mainPanel;
        }
        
        // Method to create a new management user
        private void createManagementUser() {
            // Show a dialog to collect new user information
            JTextField usernameField = new JTextField();
            JTextField roleField = new JTextField();
            JPasswordField passwordField = new JPasswordField();
            Object[] message = {
                "Username:", usernameField,
                "Password:", passwordField,
                "Role (Receptionist/RoomManager/PaymentManager):", roleField
            };
            int option = JOptionPane.showConfirmDialog(null, message, "Create Management User", JOptionPane.OK_CANCEL_OPTION);
            if(option == JOptionPane.OK_OPTION) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();
                String role = roleField.getText().trim();
                // Here you would insert the new user into the database using JDBC
                JOptionPane.showMessageDialog(null, "Management user '" + username + "' with role '" + role + "' created successfully.");
            }
        }
        
        // Method to delete an existing management user
        private void deleteManagementUser() {
            // Show a dialog to get the username of the management user to delete
            String username = JOptionPane.showInputDialog("Enter the username of the management user to delete:");
            if(username != null && !username.trim().isEmpty()) {
                // Here you would delete the user from the database using JDBC
                JOptionPane.showMessageDialog(null, "Management user '" + username + "' deleted successfully.");
            }
        }
        
        // Method to generate comprehensive reports
        private void generateAdminReports() {
            // In a real system, generate reports by querying the database and displaying them
            JOptionPane.showMessageDialog(null, "Generating comprehensive reports...");
        }
    }
    
    // Inner class for the Receptionist Dashboard Panel
    private class ReceptionistDashboardPanel extends JPanel {
        // Declare CardLayout to switch between login and main panels for Receptionist
        private CardLayout receptionistCardLayout;
        private JPanel receptionistCardPanel;
        
        // Constructor for the Receptionist Dashboard Panel
        public ReceptionistDashboardPanel() {
            // Set the layout for the ReceptionistDashboardPanel
            setLayout(new BorderLayout());
            
            // Initialize the CardLayout for Receptionist panels
            receptionistCardLayout = new CardLayout();
            
            // Create a panel that uses the CardLayout for Receptionist functionalities
            receptionistCardPanel = new JPanel(receptionistCardLayout);
            
            // Create the Receptionist login panel and the Receptionist main panel
            JPanel receptionistLoginPanel = createReceptionistLoginPanel();
            JPanel receptionistMainPanel = createReceptionistMainPanel();
            
            // Add the panels to the receptionistCardPanel with unique identifiers
            receptionistCardPanel.add(receptionistLoginPanel, "ReceptionistLogin");
            receptionistCardPanel.add(receptionistMainPanel, "ReceptionistMain");
            
            // Add the receptionistCardPanel to this dashboard panel
            add(receptionistCardPanel, BorderLayout.CENTER);
            
            // Start by showing the Receptionist login panel
            receptionistCardLayout.show(receptionistCardPanel, "ReceptionistLogin");
        }
        
        // Method to create the Receptionist Login Panel
        private JPanel createReceptionistLoginPanel() {
            // Create a panel with GridBagLayout for the login form
            JPanel loginPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            
            // Set common constraints for the layout
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            
            // Create a label for username
            JLabel usernameLabel = new JLabel("Username:");
            // Position the username label
            gbc.gridx = 0;
            gbc.gridy = 0;
            loginPanel.add(usernameLabel, gbc);
            
            // Create a text field for entering username
            JTextField usernameField = new JTextField(20);
            // Position the username field
            gbc.gridx = 1;
            gbc.gridy = 0;
            loginPanel.add(usernameField, gbc);
            
            // Create a label for password
            JLabel passwordLabel = new JLabel("Password:");
            // Position the password label
            gbc.gridx = 0;
            gbc.gridy = 1;
            loginPanel.add(passwordLabel, gbc);
            
            // Create a password field for entering password
            JPasswordField passwordField = new JPasswordField(20);
            // Position the password field
            gbc.gridx = 1;
            gbc.gridy = 1;
            loginPanel.add(passwordField, gbc);
            
            // Create a button for login
            JButton loginButton = new JButton("Login");
            // Position the login button
            gbc.gridx = 1;
            gbc.gridy = 2;
            loginPanel.add(loginButton, gbc);
            
            // Add an action listener to the login button for authentication
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // In a real system, replace this with authentication using a database connection
                    String username = usernameField.getText().trim();
                    String password = new String(passwordField.getPassword()).trim();
                    
                    // Dummy check: username and password must both be "receptionist" for successful login
                    if(username.equals("receptionist") && password.equals("receptionist")) {
                        // Switch to the main receptionist panel on successful login
                        receptionistCardLayout.show(receptionistCardPanel, "ReceptionistMain");
                    } else {
                        // Display an error message on failed login
                        JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            
            // Return the constructed Receptionist login panel
            return loginPanel;
        }
        
        // Method to create the Receptionist Main Panel with actual functionalities
        private JPanel createReceptionistMainPanel() {
            // Create a panel with BorderLayout for the main Receptionist functionalities
            JPanel mainPanel = new JPanel(new BorderLayout());
            
            // Create a label for the Receptionist Dashboard header
            JLabel headerLabel = new JLabel("Receptionist Dashboard", SwingConstants.CENTER);
            headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
            mainPanel.add(headerLabel, BorderLayout.NORTH);
            
            // Create a panel for the buttons representing different functionalities
            JPanel buttonPanel = new JPanel(new GridLayout(3, 3, 10, 10));
            
            // Create a button for changing the password
            JButton changePasswordButton = new JButton("Change Password");
            // Create a button for viewing all customers
            JButton viewCustomersButton = new JButton("View All Customers");
            // Create a button for searching for a customer by ID
            JButton searchCustomerButton = new JButton("Search Customer");
            // Create a button for registering a new customer
            JButton registerCustomerButton = new JButton("Register New Customer");
            // Create a button for placing a reservation order
            JButton placeReservationButton = new JButton("Place Reservation Order");
            // Create a button for canceling a reservation order
            JButton cancelReservationButton = new JButton("Cancel Reservation Order");
            // Create a button for viewing all reservations
            JButton viewReservationsButton = new JButton("View All Reservations");
            // Create a button for creating customer bills
            JButton createBillButton = new JButton("Create Customer Bill");
            // Create a button for logging out
            JButton logoutButton = new JButton("Logout");
            
            // Add action listener for Change Password button
            changePasswordButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    changeReceptionistPassword();
                }
            });
            
            // Add action listener for View All Customers button
            viewCustomersButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    viewAllCustomers();
                }
            });
            
            // Add action listener for Search Customer button
            searchCustomerButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    searchCustomerByID();
                }
            });
            
            // Add action listener for Register New Customer button
            registerCustomerButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    registerNewCustomer();
                }
            });
            
            // Add action listener for Place Reservation Order button
            placeReservationButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    placeReservationOrder();
                }
            });
            
            // Add action listener for Cancel Reservation Order button
            cancelReservationButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelReservationOrder();
                }
            });
            
            // Add action listener for View All Reservations button
            viewReservationsButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    viewAllReservations();
                }
            });
            
            // Add action listener for Create Customer Bill button
            createBillButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    createCustomerBill();
                }
            });
            
            // Add action listener for Logout button
            logoutButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    receptionistCardLayout.show(receptionistCardPanel, "ReceptionistLogin");
                }
            });
            
            // Add all buttons to the button panel
            buttonPanel.add(changePasswordButton);
            buttonPanel.add(viewCustomersButton);
            buttonPanel.add(searchCustomerButton);
            buttonPanel.add(registerCustomerButton);
            buttonPanel.add(placeReservationButton);
            buttonPanel.add(cancelReservationButton);
            buttonPanel.add(viewReservationsButton);
            buttonPanel.add(createBillButton);
            buttonPanel.add(logoutButton);
            
            // Add the button panel to the center of the main panel
            mainPanel.add(buttonPanel, BorderLayout.CENTER);
            
            // Return the constructed Receptionist main panel
            return mainPanel;
        }
        
        // Method to change the receptionist password
        private void changeReceptionistPassword() {
            // In a real system, implement password change logic using JDBC
            JOptionPane.showMessageDialog(null, "Password change functionality executed.");
        }
        
        // Method to view all customers
        private void viewAllCustomers() {
            // In a real system, retrieve customer data from the database and display it
            JOptionPane.showMessageDialog(null, "Displaying all customers.");
        }
        
        // Method to search for a customer by ID
        private void searchCustomerByID() {
            String customerId = JOptionPane.showInputDialog("Enter Customer ID:");
            if(customerId != null && !customerId.trim().isEmpty()){
                // In a real system, perform a database search for the customer by ID
                JOptionPane.showMessageDialog(null, "Results for customer ID: " + customerId);
            }
        }
        
        // Method to register a new customer
        private void registerNewCustomer() {
            // In a real system, collect new customer details and insert into the database
            JOptionPane.showMessageDialog(null, "New customer registered successfully.");
        }
        
        // Method to place a reservation order
        private void placeReservationOrder() {
            // In a real system, collect reservation details and create a new reservation record
            JOptionPane.showMessageDialog(null, "Reservation order placed successfully.");
        }
        
        // Method to cancel a reservation order
        private void cancelReservationOrder() {
            // In a real system, cancel the reservation order in the database
            JOptionPane.showMessageDialog(null, "Reservation order cancelled successfully.");
        }
        
        // Method to view all reservations
        private void viewAllReservations() {
            // In a real system, retrieve reservation records from the database and display them
            JOptionPane.showMessageDialog(null, "Displaying all reservations.");
        }
        
        // Method to create a customer bill
        private void createCustomerBill() {
            // In a real system, generate a bill based on reservation details and customer data
            JOptionPane.showMessageDialog(null, "Customer bill created successfully.");
        }
    }
    
    // Inner class for the Room Manager Dashboard Panel
    private class RoomManagerDashboardPanel extends JPanel {
        // Declare CardLayout to switch between login and main panels for Room Manager
        private CardLayout roomManagerCardLayout;
        private JPanel roomManagerCardPanel;
        
        // Constructor for the Room Manager Dashboard Panel
        public RoomManagerDashboardPanel() {
            // Set the layout for the RoomManagerDashboardPanel
            setLayout(new BorderLayout());
            
            // Initialize the CardLayout for Room Manager panels
            roomManagerCardLayout = new CardLayout();
            
            // Create a panel that uses the CardLayout for Room Manager functionalities
            roomManagerCardPanel = new JPanel(roomManagerCardLayout);
            
            // Create the Room Manager login panel and the Room Manager main panel
            JPanel roomManagerLoginPanel = createRoomManagerLoginPanel();
            JPanel roomManagerMainPanel = createRoomManagerMainPanel();
            
            // Add the panels to the roomManagerCardPanel with unique identifiers
            roomManagerCardPanel.add(roomManagerLoginPanel, "RoomManagerLogin");
            roomManagerCardPanel.add(roomManagerMainPanel, "RoomManagerMain");
            
            // Add the roomManagerCardPanel to this dashboard panel
            add(roomManagerCardPanel, BorderLayout.CENTER);
            
            // Start by showing the Room Manager login panel
            roomManagerCardLayout.show(roomManagerCardPanel, "RoomManagerLogin");
        }
        
        // Method to create the Room Manager Login Panel
        private JPanel createRoomManagerLoginPanel() {
            // Create a panel with GridBagLayout for the login form
            JPanel loginPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            
            // Set common constraints for the layout
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            
            // Create a label for username
            JLabel usernameLabel = new JLabel("Username:");
            // Position the username label
            gbc.gridx = 0;
            gbc.gridy = 0;
            loginPanel.add(usernameLabel, gbc);
            
            // Create a text field for entering username
            JTextField usernameField = new JTextField(20);
            // Position the username field
            gbc.gridx = 1;
            gbc.gridy = 0;
            loginPanel.add(usernameField, gbc);
            
            // Create a label for password
            JLabel passwordLabel = new JLabel("Password:");
            // Position the password label
            gbc.gridx = 0;
            gbc.gridy = 1;
            loginPanel.add(passwordLabel, gbc);
            
            // Create a password field for entering password
            JPasswordField passwordField = new JPasswordField(20);
            // Position the password field
            gbc.gridx = 1;
            gbc.gridy = 1;
            loginPanel.add(passwordField, gbc);
            
            // Create a button for login
            JButton loginButton = new JButton("Login");
            // Position the login button
            gbc.gridx = 1;
            gbc.gridy = 2;
            loginPanel.add(loginButton, gbc);
            
            // Add an action listener to the login button for authentication
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // In a real system, replace this with authentication using a database connection
                    String username = usernameField.getText().trim();
                    String password = new String(passwordField.getPassword()).trim();
                    
                    // Dummy check: username and password must both be "roommanager" for successful login
                    if(username.equals("roommanager") && password.equals("roommanager")) {
                        // Switch to the main Room Manager panel on successful login
                        roomManagerCardLayout.show(roomManagerCardPanel, "RoomManagerMain");
                    } else {
                        // Display an error message on failed login
                        JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            
            // Return the constructed Room Manager login panel
            return loginPanel;
        }
        
        // Method to create the Room Manager Main Panel with actual functionalities
        private JPanel createRoomManagerMainPanel() {
            // Create a panel with BorderLayout for the main Room Manager functionalities
            JPanel mainPanel = new JPanel(new BorderLayout());
            
            // Create a label for the Room Manager Dashboard header
            JLabel headerLabel = new JLabel("Room Manager Dashboard", SwingConstants.CENTER);
            headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
            mainPanel.add(headerLabel, BorderLayout.NORTH);
            
            // Create a panel for the buttons representing different functionalities
            JPanel buttonPanel = new JPanel(new GridLayout(3, 3, 10, 10));
            
            // Create a button for changing the password
            JButton changePasswordButton = new JButton("Change Password");
            // Create a button for listing new rooms
            JButton listRoomButton = new JButton("List New Room");
            // Create a button for removing rooms
            JButton removeRoomButton = new JButton("Remove Room");
            // Create a button for updating room information
            JButton updateRoomButton = new JButton("Update Room Info");
            // Create a button for viewing reservation orders
            JButton viewReservationOrdersButton = new JButton("View Reservation Orders");
            // Create a button for approving reservation orders
            JButton approveReservationButton = new JButton("Approve Reservation Order");
            // Create a button for viewing cancellation orders
            JButton viewCancellationOrdersButton = new JButton("View Cancellation Orders");
            // Create a button for approving cancellation orders
            JButton approveCancellationButton = new JButton("Approve Cancellation Order");
            // Create a button for logging out
            JButton logoutButton = new JButton("Logout");
            
            // Add action listener for Change Password button
            changePasswordButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    changeRoomManagerPassword();
                }
            });
            
            // Add action listener for List New Room button
            listRoomButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    listNewRoom();
                }
            });
            
            // Add action listener for Remove Room button
            removeRoomButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    removeRoom();
                }
            });
            
            // Add action listener for Update Room Info button
            updateRoomButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    updateRoomInformation();
                }
            });
            
            // Add action listener for View Reservation Orders button
            viewReservationOrdersButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    viewRoomReservationOrders();
                }
            });
            
            // Add action listener for Approve Reservation Order button
            approveReservationButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    approveRoomReservationOrder();
                }
            });
            
            // Add action listener for View Cancellation Orders button
            viewCancellationOrdersButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    viewReservationCancellationOrders();
                }
            });
            
            // Add action listener for Approve Cancellation Order button
            approveCancellationButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    approveReservationCancellationOrder();
                }
            });
            
            // Add action listener for Logout button
            logoutButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    roomManagerCardLayout.show(roomManagerCardPanel, "RoomManagerLogin");
                }
            });
            
            // Add all buttons to the button panel
            buttonPanel.add(changePasswordButton);
            buttonPanel.add(listRoomButton);
            buttonPanel.add(removeRoomButton);
            buttonPanel.add(updateRoomButton);
            buttonPanel.add(viewReservationOrdersButton);
            buttonPanel.add(approveReservationButton);
            buttonPanel.add(viewCancellationOrdersButton);
            buttonPanel.add(approveCancellationButton);
            buttonPanel.add(logoutButton);
            
            // Add the button panel to the center of the main panel
            mainPanel.add(buttonPanel, BorderLayout.CENTER);
            
            // Return the constructed Room Manager main panel
            return mainPanel;
        }
        
        // Method to change the room manager password
        private void changeRoomManagerPassword() {
            // In a real system, implement password change logic using JDBC
            JOptionPane.showMessageDialog(null, "Password change functionality executed.");
        }
        
        // Method to list a new room with details
        private void listNewRoom() {
            // In a real system, collect room details and insert into the database
            JTextField roomNumberField = new JTextField();
            JTextField roomTypeField = new JTextField();
            JTextField priceField = new JTextField();
            Object[] message = {
                "Room Number:", roomNumberField,
                "Room Type (Single/Double/Suite):", roomTypeField,
                "Price per Night:", priceField
            };
            int option = JOptionPane.showConfirmDialog(null, message, "List New Room", JOptionPane.OK_CANCEL_OPTION);
            if(option == JOptionPane.OK_OPTION) {
                // Process the room details and insert into the database
                JOptionPane.showMessageDialog(null, "Room listed successfully.");
            }
        }
        
        // Method to remove a room from the system
        private void removeRoom() {
            // In a real system, remove the room record from the database based on room number
            String roomNumber = JOptionPane.showInputDialog("Enter Room Number to Remove:");
            if(roomNumber != null && !roomNumber.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Room " + roomNumber + " removed successfully.");
            }
        }
        
        // Method to update room information
        private void updateRoomInformation() {
            // In a real system, update room details in the database
            String roomNumber = JOptionPane.showInputDialog("Enter Room Number to Update:");
            if(roomNumber != null && !roomNumber.trim().isEmpty()){
                JTextField roomTypeField = new JTextField();
                JTextField priceField = new JTextField();
                Object[] message = {
                    "New Room Type:", roomTypeField,
                    "New Price per Night:", priceField
                };
                int option = JOptionPane.showConfirmDialog(null, message, "Update Room Info", JOptionPane.OK_CANCEL_OPTION);
                if(option == JOptionPane.OK_OPTION){
                    JOptionPane.showMessageDialog(null, "Room " + roomNumber + " updated successfully.");
                }
            }
        }
        
        // Method to view room reservation orders
        private void viewRoomReservationOrders() {
            // In a real system, retrieve reservation orders from the database and display them
            JOptionPane.showMessageDialog(null, "Displaying room reservation orders.");
        }
        
        // Method to approve a room reservation order
        private void approveRoomReservationOrder() {
            // In a real system, update the reservation order status in the database
            JOptionPane.showMessageDialog(null, "Room reservation order approved and reservation created.");
        }
        
        // Method to view reservation cancellation orders
        private void viewReservationCancellationOrders() {
            // In a real system, retrieve cancellation orders from the database and display them
            JOptionPane.showMessageDialog(null, "Displaying reservation cancellation orders.");
        }
        
        // Method to approve a reservation cancellation order
        private void approveReservationCancellationOrder() {
            // In a real system, update the cancellation order in the database and delete the reservation
            JOptionPane.showMessageDialog(null, "Reservation cancellation approved and reservation deleted.");
        }
    }
    
    // Inner class for the Payment Manager Dashboard Panel
    private class PaymentManagerDashboardPanel extends JPanel {
        // Declare CardLayout to switch between login and main panels for Payment Manager
        private CardLayout paymentManagerCardLayout;
        private JPanel paymentManagerCardPanel;
        
        // Constructor for the Payment Manager Dashboard Panel
        public PaymentManagerDashboardPanel() {
            // Set the layout for the PaymentManagerDashboardPanel
            setLayout(new BorderLayout());
            
            // Initialize the CardLayout for Payment Manager panels
            paymentManagerCardLayout = new CardLayout();
            
            // Create a panel that uses the CardLayout for Payment Manager functionalities
            paymentManagerCardPanel = new JPanel(paymentManagerCardLayout);
            
            // Create the Payment Manager login panel and the Payment Manager main panel
            JPanel paymentManagerLoginPanel = createPaymentManagerLoginPanel();
            JPanel paymentManagerMainPanel = createPaymentManagerMainPanel();
            
            // Add the panels to the paymentManagerCardPanel with unique identifiers
            paymentManagerCardPanel.add(paymentManagerLoginPanel, "PaymentManagerLogin");
            paymentManagerCardPanel.add(paymentManagerMainPanel, "PaymentManagerMain");
            
            // Add the paymentManagerCardPanel to this dashboard panel
            add(paymentManagerCardPanel, BorderLayout.CENTER);
            
            // Start by showing the Payment Manager login panel
            paymentManagerCardLayout.show(paymentManagerCardPanel, "PaymentManagerLogin");
        }
        
        // Method to create the Payment Manager Login Panel
        private JPanel createPaymentManagerLoginPanel() {
            // Create a panel with GridBagLayout for the login form
            JPanel loginPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            
            // Set common constraints for the layout
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            
            // Create a label for username
            JLabel usernameLabel = new JLabel("Username:");
            // Position the username label
            gbc.gridx = 0;
            gbc.gridy = 0;
            loginPanel.add(usernameLabel, gbc);
            
            // Create a text field for entering username
            JTextField usernameField = new JTextField(20);
            // Position the username field
            gbc.gridx = 1;
            gbc.gridy = 0;
            loginPanel.add(usernameField, gbc);
            
            // Create a label for password
            JLabel passwordLabel = new JLabel("Password:");
            // Position the password label
            gbc.gridx = 0;
            gbc.gridy = 1;
            loginPanel.add(passwordLabel, gbc);
            
            // Create a password field for entering password
            JPasswordField passwordField = new JPasswordField(20);
            // Position the password field
            gbc.gridx = 1;
            gbc.gridy = 1;
            loginPanel.add(passwordField, gbc);
            
            // Create a button for login
            JButton loginButton = new JButton("Login");
            // Position the login button
            gbc.gridx = 1;
            gbc.gridy = 2;
            loginPanel.add(loginButton, gbc);
            
            // Add an action listener to the login button for authentication
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // In a real system, replace this with authentication using a database connection
                    String username = usernameField.getText().trim();
                    String password = new String(passwordField.getPassword()).trim();
                    
                    // Dummy check: username and password must both be "payment" for successful login
                    if(username.equals("payment") && password.equals("payment")) {
                        // Switch to the main Payment Manager panel on successful login
                        paymentManagerCardLayout.show(paymentManagerCardPanel, "PaymentManagerMain");
                    } else {
                        // Display an error message on failed login
                        JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            
            // Return the constructed Payment Manager login panel
            return loginPanel;
        }
        
        // Method to create the Payment Manager Main Panel with actual functionalities
        private JPanel createPaymentManagerMainPanel() {
            // Create a panel with BorderLayout for the main Payment Manager functionalities
            JPanel mainPanel = new JPanel(new BorderLayout());
            
            // Create a label for the Payment Manager Dashboard header
            JLabel headerLabel = new JLabel("Payment Manager Dashboard", SwingConstants.CENTER);
            headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
            mainPanel.add(headerLabel, BorderLayout.NORTH);
            
            // Create a panel for the buttons representing different functionalities
            JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 20, 20));
            
            // Create a button for changing the password
            JButton changePasswordButton = new JButton("Change Password");
            // Create a button for viewing all bills
            JButton viewBillsButton = new JButton("View All Bills");
            // Create a button for clearing a bill
            JButton clearBillButton = new JButton("Clear Bill");
            // Create a button for generating payment reports
            JButton generatePaymentReportButton = new JButton("Generate Payment Report");
            // Create a button for logging out
            JButton logoutButton = new JButton("Logout");
            
            // Add action listener for Change Password button
            changePasswordButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    changePaymentManagerPassword();
                }
            });
            
            // Add action listener for View All Bills button
            viewBillsButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    viewAllBills();
                }
            });
            
            // Add action listener for Clear Bill button
            clearBillButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clearBill();
                }
            });
            
            // Add action listener for Generate Payment Report button
            generatePaymentReportButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    generatePaymentReports();
                }
            });
            
            // Add action listener for Logout button
            logoutButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    paymentManagerCardLayout.show(paymentManagerCardPanel, "PaymentManagerLogin");
                }
            });
            
            // Add all buttons to the button panel
            buttonPanel.add(changePasswordButton);
            buttonPanel.add(viewBillsButton);
            buttonPanel.add(clearBillButton);
            buttonPanel.add(generatePaymentReportButton);
            buttonPanel.add(logoutButton);
            
            // Add the button panel to the center of the main panel
            mainPanel.add(buttonPanel, BorderLayout.CENTER);
            
            // Return the constructed Payment Manager main panel
            return mainPanel;
        }
        
        // Method to change the payment manager password
        private void changePaymentManagerPassword() {
            // In a real system, implement password change logic using JDBC
            JOptionPane.showMessageDialog(null, "Password change functionality executed.");
        }
        
        // Method to view all bills
        private void viewAllBills() {
            // In a real system, retrieve bill records from the database and display them
            JOptionPane.showMessageDialog(null, "Displaying all bills.");
        }
        
        // Method to clear a bill after payment
        private void clearBill() {
            // In a real system, update the bill status in the database
            String billId = JOptionPane.showInputDialog("Enter Bill ID to Clear:");
            if(billId != null && !billId.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Bill " + billId + " cleared successfully.");
            }
        }
        
        // Method to generate payment reports
        private void generatePaymentReports() {
            // In a real system, generate payment reports by querying the database
            JOptionPane.showMessageDialog(null, "Generating payment reports...");
        }
    }
    
    // Main method to launch the Hotel Reservation System application
    public static void main(String[] args) {
        // Ensure that the GUI creation runs on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create an instance of the HotelReservationSystem
                HotelReservationSystem reservationSystem = new HotelReservationSystem();
                
                // Make the main frame visible
                reservationSystem.setVisible(true);
            }
        });
    }
}

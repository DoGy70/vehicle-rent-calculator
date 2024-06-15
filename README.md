This is a console application designed to calculate rent for different types of vehicles. I have used an abstract class that contains all the fields common to the different types of vehicles. There is a separate class for each vehicle type that extends the abstract class. Additionally, there is an enum used in each class to determine the type of vehicle. When the application starts, the user is asked for their first and last name, and the application assumes the current date is when the user will return their rented vehicle. The application then asks for the type of vehicle being returned and performs the calculations accordingly. The input is validated using while loops to ensure only valid information is accepted. After the calculations are completed, the user is presented with a list of the total amount they need to pay and all its components. I have also created a class for the invoice, which has its own toString method used to print out all the information conditionally.
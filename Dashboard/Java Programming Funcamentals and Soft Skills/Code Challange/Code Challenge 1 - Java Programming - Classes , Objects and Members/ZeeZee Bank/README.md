# ZeeZee Bank
 
ZeeZee is a leading private sector bank. In the last Annual meeting, they decided to give their customer a 24/7 banking facility.
As an initiative, the bank outlined to develop a standalone device that would offer deposit and withdrawal of money to the customers anytime.
 
You being the software consultant have been approached to develop software to implement the functionality of deposit and withdraw anytime.
 
## Component Specification: Account
 
| Type(Class) | Attributes | Methods | Responsibilities |
| ----------- | ---------- | ------- | ---------------- |
| Account | long accountNumber<br>double balanceAmount | Include the getters and setters method for all the attributes.<br>Include a parameterized constructor of two arguments in the order - accountNumber, balanceAmount to initialize the values for the account object | |
 
### Requirement 1:
 
Being able to deposit money into an account anytime
 
As per the requirement, the customer should be abloe to deposit money into his account at any time and the deposited amount should reflect in his account balance.
 
## Component Specification: Account
 
| Component Name | Type(Class) | Methods | Responsibilities |
| -------------- | ----------- | ------- | ---------------- |
| Deposit amount to an account | Account | public void deposit(double depositAmt) | This method takes the amount to be deposited as an argument.<br>This method should perform the deposit, by adding the deposited amount to the balanceAmount.
 
 
## Component Specification: Account
 
| Component Name | Type(Class) | Methods | Responsibilities |
| -------------- | ----------- | ------- | ---------------- |
| Withdraw amount from an account | Account | public boolean withdraw(double withdrawAmt) | This method should take the amount to be withdrawn as an argument.<br>This method should check the balanceAmount and deduct the withdraw amount from the balanceAmount and return true. If there is insufficient balance then return false. |
 
In the **Main** class, Get the details as shown in the sample input.
 
Create an object for the account class and invoke the deposit method to deposit the amount and withdraw method to withdraw the amount from the account.
 
All classes and methods should be public, Attributes should be private.
 
### Note
 
Balance amount should be displayed corrected to 2 decimal places.
 
Order of the transactions to be performed (Display, Deposit, Withdraw).
 
If the balance amount is insufficient then display the message as shown in the Sample input / output.
 
In the Sample input / output provided, the highested test in bold corresponds to the input given by the user and the rest of the text represents the output.
 
Ensure to follow the object-oriented specification provided in the question.
 
Ensure to provide the names for classes, attributes, and methods as specified in the question.
 
 
> Sample Input and Output 1:
 
   Enter the account number:
   9876543210
   Enter initial balance:
   15000
   Enter the amount to be deposited:
   1500
   Available balance is:16500.00
   Enter the amount to be withdrawn:
   500
   Available balance is:16000.00
 
> Sample Input and Output 2:
 
   Enter the account number:
   9876543210
   Enter initial balance:
   15000
   Enter the amount to be deposited:
   1500
   Available balance is:
   16500.00
   Enter the amount to be withdrawn:
   18500
   Insufficient balance
   Available balance is:16500.00

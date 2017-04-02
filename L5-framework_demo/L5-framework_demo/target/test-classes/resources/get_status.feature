Feature: Customer Order's Status
       As a saler,
       I want to check
       if there are orders with status \"Pending\"
 
Scenario: There is status Pending
       Given the user is on Orders Page
       When he Hovers on Sales tab
       And he Clicks on Orders tab
       And he Selects Order Status Filter
       And he Chooses option "Pending"
       And he Clicks on Filter Button
       Then ensure all the rows have in [3]rd column "Pending" text

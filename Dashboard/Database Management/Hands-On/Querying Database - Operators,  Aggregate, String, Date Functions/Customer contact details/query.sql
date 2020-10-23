select customer_id, customer_name, ifnull(address, ifnull(email_id, "NA")) as contact_details
from customers
order by customer_id;

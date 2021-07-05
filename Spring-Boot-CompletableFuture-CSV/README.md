As i first tried to save the 10000 rows by 

performance matters then 1st rank -> TABLE , 2nd rank -> Sequence, 3rd rank -> Identity

100k records - multithreading(CompletableFuture) -> 73501 -> 73.5 seconds
100k records - normal-> thread block takes(Most concerned problem this is) -> 110.5016 seconds  
100k records - multithreading(CompletableFuture) with spring.jpa.properties.hibernate.jdbc.batch_size=30000 this it takes -> 30223 -> 30.2 seconds --> Best**


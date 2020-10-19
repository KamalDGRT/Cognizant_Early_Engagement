drop database if exists RainfallReport;

create database RainfallReport;

use RainfallReport;

create table AnnualRainfall
(
    city_pincode            int(5) primary key,
    city_name               varchar(25),
    average_annual_rainfall double(6, 2)
);

insert into AnnualRainfall
values (10002, 'New York', 19.833),
       (99501, 'Alaska', 22.666),
       (20019, 'Washington', 35.006),
       (30381, 'Oxford', 22.666),
       (90080, 'Angeles', 42);

select *
from AnnualRainfall;

select *
from AnnualRainfall
where average_annual_rainfall = (
    select max(average_annual_rainfall)
    from AnnualRainfall
);

commit;
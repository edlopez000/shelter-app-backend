alter table animal
    rename column "colorLevel" to color_level;

alter table animal
    rename column "intakeDate" to intake_date;

alter table animal
    rename column "exitDate" to exit_date;

alter table animal
    rename column "rescueOnly" to rescue_only;

alter table volunteer
    rename column "firstName" to first_name;

alter table volunteer
    rename column "lastName" to last_name;

alter table volunteer
    rename column "mobilePhone" to mobile_phone;

alter table volunteer
    rename column "volunteerOrientation" to volunteer_orientation;

alter table volunteer
    rename column "canineOrientation" to canine_orientation;

alter table volunteer
    rename column "felineOrientation" to feline_orientation;

alter table volunteer
    rename column "canineColorLevel" to canine_color_level;

alter table volunteer
    rename column "felineColorLevel" to feline_color_level;

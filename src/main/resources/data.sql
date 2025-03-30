insert into venues(venue_name,location) values ('Thailand','Bangkork'),
                                               ('USA','New York'),
                                               ('South Korea','Seoul');

select * from venues;

insert into events(event_name,venue_id) values ('KSGA',1);

select * from events;

insert into attendees(attendee_name, email) values ('Pilot','Pilot@gmail.com'),
                                                   ('Relexsun','Relexsun@gmail.com'),
                                                   ('Karkara','Karkara@gmail.com'),
                                                   ('Sengdara','Sengdara@gmail.com'),
                                                   ('Piset','Piset@gmail.com');
select * from attendees;

SELECT * FROM venues;

SELECT * FROM events es INNER JOIN venues vs ON es.event_id = vs.venue_id;

SELECT * FROM events;

INSERT INTO events(event_name,venue_id) VALUES ('SETEC',2)

SELECT * FROM attendees;

UPDATE attendees SET attendee_name= 'Ponle',email = 'Ponle@gmail.com' WHERE attendee_id = 4

SELECT * FROM event_attendee;

INSERT INTO event_attendee(event_id,attendee_id) VALUES(1,4),
    (2,5),
    (2,6);

INSERT INTO
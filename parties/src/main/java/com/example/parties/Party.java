package com.example.parties;

@Entity
@Table(name = "party")
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String party_name;
    private int party_count;
    private Object date_created;


    // Constructor, getters and setters   
}
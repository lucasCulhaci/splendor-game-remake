## **IMPORTANT**
Do not save anything locally on your PC. Ensure that everything is accessible online at all times!

The latest code is on GitHub, the latest analysis + design can be found on VP online, and share other documents via OneDrive for all team members and the accompanying lecturer.

# CONTACT MOMENT

Every **Friday morning** from **08:15 to 10:15** in room **GSCHB.3.037**, **MANDATORY ATTENDANCE!**

# BROCHURE

**Subjects you need to master:**
* Databases
* Software Analysis
* Object-Oriented Software Development I (OOSD I)
* Object-Oriented Software Development II (OOSD II)

**Everyone** in the project group contributes to each part (analysis, design, testing, programming, database).

## Semester Planning

| Week | TODO |
|------|------|
| 1 | attend online information session + join a group |
| 2 | set up working environment (explanation of documents + instructional videos) |
| 3 | start with use case 1 |
| 4-11 | weekly contact moment to track progress and discuss questions |
| 12 | submit final project result |
| 13 | technical final presentation |

## Contact Moments

**Absent at contact moment?** > notify the accompanying lecturer and group members + officially report via **iBamaFlex** within **48 hours**!

**Absent at final presentation?** > DEF first attempt, must be made up during the feedback of the second attempt.

**2 or more unjustified absences?** > DEF as an exam grade for the course AND take the absences to your second attempt.

# Assignment

## What is Splendor?

Splendor is a card game for 2 to 4 players. During the game, you collect gemstone tokens that you can use to buy development cards. With these cards, you can earn points, but they also guarantee a bonus. With this bonus, you can get the next development cards you want to buy at a lower cost. Meanwhile, you try to create combinations of development cards to attract nobles to you. This earns you extra points. Once someone has reached 15 points, each player gets one more turn. When everyone has had an equal number of turns, the player with the most points wins.

[> Rules explained on YouTube](https://www.youtube.com/watch?v=rue8-jvbc9I&ab_channel=WatchItPlayed)

## How to Approach the Project?

The assignment of the game was outlined in a number of use cases. The use cases are the contract with your customer, describing exactly how everything should work. So, don't start programming randomly. Follow exactly what is described in the use case. Go through all phases of an iteration (analysis, design, testing, implementation). Once one iteration is completed, you can start the next one.

1. UC1 - Create a new game
2. UC2 - Play the game
3. UC3 - Play a round
4. UC4 - Play a turn

Create per use case (contains all required functionality).

> Click on the references to view their criteria.

1. Create per use case:

    * [Database design](#criterium-5-databank)
    * [Analysis](#criterium-1-analyseren)
    * [Design DCD](#criterium-2-ontwerpen)
    * [Console Application](#criterium-4-programmeren)

2. [Develop a Graphical User Interface](#criterium-3-volledigheid-product-qua-niet-functionele-requirements)

3. [Application is multilingual](#criterium-3-volledigheid-product-qua-niet-functionele-requirements)

4. For each use case, a **working document** is completed:
    * [Database design](#criterium-5-databank)
    * [Analysis](#criterium-1-analyseren)
    * [Design DCD](#criterium-2-ontwerpen)

5. Keep a [logbook](#logboek).

    [> Open logbook](https://hogent-my.sharepoint.com/:w:/r/personal/liesbeth_lewyllie_hogent_be/_layouts/15/Doc.aspx?sourcedoc=%7B332FAE97-C205-4E55-975D-1E1DF1F000CA%7D&file=opvolgingsformulier.docx&action=default&mobileredirect=true)

6. Maintain an [follow-up form](#opvolgingsformulier).

    [> Open follow-up form](https://hogent-my.sharepoint.com/:w:/r/personal/liesbeth_lewyllie_hogent_be/_layouts/15/Doc.aspx?sourcedoc=%7B332FAE97-C205-4E55-975D-1E1DF1F000CA%7D&file=opvolgingsformulier.docx&action=default&mobileredirect=true)

[> OPEN FULL PRODUCT DEVELOPMENT](#productontwikkeling)

# Point Distribution

70% > Product + Product Development  
30% > Process (teamwork, attitudes)

## Product (final result)

### Criterion 1: Completeness of product in terms of form

1. Final dossier with
    * table of contents
    * numbered pages
    * **per UC analysis, design, database**
    * reflection on group work from each group member
2. Eclipse project with code and VP UML diagrams
3. generated javadoc API of the domain

### Criterion 2: Completeness of product in terms of functionality

All functionalities are described in the use cases.

### Criterion 3: Completeness of product in terms of non-functional requirements

* user interface (console / graphical)
* **multilingual application**

## Product Development

### Criterion 1: Analyzing

**Apply rules from Software Analysis!**

* activity diagram
* domain model
* SSD, accompanying OCs

### Criterion 2: Designing

**Apply rules from OOSD I and the established analysis!**

Prepare the DCD:
* DCD aligns with SSDs
* DCD contains what was described in OC

### Criterion 3: Testing

Every "pure" domain class, i.e., NOT DomainController and repository classes, is adequately tested through JUNIT tests.

### Criterion 4: Programming

**Apply rules from OOSD I, OOSD II, and the established design!**

* adhere to OO principles
* adhere to the 3 layers
* document correctly throughout the entire process
* robust application
* find the correct methods from the DCD in the code

### Criterion 5: Database

**Apply rules from Databases!**

* conceptual ERD model
* corresponding relational model
* script with DDL instructions for implementation in a relational database (MySQL)

You must be able to read & write data!

# Process

## Criterion 1: Registration

Complete the logbook and follow-up form.

## Criterion 2: Planning

Create a weekly plan, work according to that plan, and check if you are on schedule.

## Criterion 3: Teamwork

Collaborate effectively and encourage teamwork.

## Criterion 4: Preparation for Weekly Contact Moment

Preparation means:
- Presenting and being aware of the work from the past week
- Listing and bringing questions

## Criterion 5: Dealing with Feedback / Following Advice

This includes both substantive and procedural feedback.

## Criterion 6: Punctuality

Be punctual for every appointment (online or at school).

> Each criterion is described at 5 levels (see extras). Twice (midway through the semester and at the end), you will have to determine for yourself at which level you are for each criterion and also indicate that. Self-awareness is an important link in successful teamwork.

# Final Products

At the end of the project, you will submit a well-prepared dossier containing:
- Cover page (see Chamilo)
- ERD, relational model, script with DDL instructions (per use case if applicable)
- Analysis and design (domain model, activity diagram, SSD, OC, and DCD) per use case (or scenario if applicable);
- 1 A4 page of text per group member with your experiences regarding group work: what have you learned, what were the difficulties, what are your strengths, ...

Submit your project via the Chamilo assignments module:  
Create 1 zip file with:

- Well-prepared dossier
- Eclipse project with the Java code
- The generated Java documentation of the code (Javadoc)
- The complete analysis and design (vpp file from Visual Paradigm)
- Script with DDL instructions of the MySQL database
- Export file of the MySQL database (all data)

**Submit this completed dossier via the assignments module in Chamilo before Monday, May 15, 23:59**

## Recording

**Via Teams (recording of a meeting with the entire team), create a video demonstrating your final result.**  
The final result is an application with a graphical user interface showcasing all requested functionalities.  
This video is also a group effort, with each team member speaking.  
This video is available via Teams no later than Monday, May 15, 23:59.  
This video is not edited; nothing needs to be cut. It is the recording of a live demo.

## Digital Dossier

During the semester, you also build a digital dossier. Each group gets its own documents folder on OneDrive. This folder is only accessible to group members and all accompanying lecturers.

## Logbook

Whenever a group member works on the project, they note the details of the work (description and time registration) in the logbook.

The follow-up form is also included here.

[> Open logbook](https://hogent-my.sharepoint.com/:w:/r/personal/liesbeth_lewyllie_hogent_be/_layouts/15/Doc.aspx?sourcedoc=%7B332FAE97-C205-4E55-975D-1E1DF1F000CA%7D&file=opvolgingsformulier.docx&action=default&mobileredirect=true)

## Follow-up Form

As preparation for the weekly meeting with your supervising lecturer, fill in the follow-up form (what happened last week and what will we do next week, group agreements, possible questions…).

### DONE

**Complete this before the meeting!** What have you done in the past week?

### TODO:

**Complete this before the meeting!** What do you plan to do next week?

### How is the group work progressing?
Note all issues, questions, strengths, ...

[> Open follow-up form](https://hogent-my.sharepoint.com/:w:/r/personal/liesbeth_lewyllie_hogent_be/_layouts/15/Doc.aspx?sourcedoc=%7B332FAE97-C205-4E55-975D-1E1DF1F000CA%7D&file=opvolgingsformulier.docx&action=default&mobileredirect=true)

# Final Presentation: Example Questions

1. How do resource bundles work? What is their purpose? Show in the code how you work with them. Explain.
2. What is the purpose/advantage of the Javadoc comment? Demonstrate.
3. Show that your application for UC... is a robust application.
4. What is the task/responsibility of a DomainController? Support each time with an example from your project.
5. What are the responsibilities of a repository class? Support each time with an example from your project.
6. What does a mapper class do? Discuss the code of a method in such a mapper class.
7. Illustrate how and to which products you came during the analysis of UC x (domain model/SSD/OC/AD).
8. Illustrate how doing and knowing responsibilities are kept separate in the project.
9. Illustrate how you applied GRASP patterns (controller expert/creator) when creating the design.
10. Explain briefly the 3-layer model and illustrate its application with an example from your code.
11. The design of the graphical layer is highly dependent on the programming language. Explain how you built this layer in your project.
12. Event handling and/or screen switching: show an example from your project and explain the code.
13. Illustrate how you tested your application using analysis schemas for UCx.
14. Discuss how and why your domain model, EERD, and DCD are different.
15. Demonstrate and explain how you are sure that domain class X works well.

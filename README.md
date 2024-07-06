# CSCI 205 -Software Engineering and Design
Bucknell University  Lewisburg, PA

### Course Info
Instructor: Professor King

Semester: Spring

## Team Information 
Team 8: King's Queens

(Scrum Master) -Angel Sousani: Sophomore, Major: Psychology   
(Developer) - Aya Tarist: Sophomore, Major: Computer Science Engineer
(Developer) - Marina Anglo: Sophomore, Major: Computer Science
(Project Manager) -Thao Nguyen: Sophomore, Major: Computer Science, Film Studies

## Project Information
SUMMARY
Flying Bison, a 2D side-scrolling that is inspired by the game Flappy Bison. 
The game's objective is to give a user control of a bison. The game has an opening starting
page with our flappy bison (Appa) in the middle of the screen in front of nature
themed background. At the press of the start button, a user playing the game has control
over the bison with the use of their cursor. Their task will be to move the bison 
through generated obstacles without falling to the ground or hitting any of the pipes. 
Each time the Bison moves through a pipe, the player gains an extra point and will
continue to acquire points until it hits a pipe or an outer border.

PACKAGE STRUCTURE
Our main project is found in the KQ package which has seven java classes. 
- BisonMain is where our main method that runs our program is. 
- Bison class has a constructor and the method which checks to see if the Bison is 
dead, meaning it has hit an obstacle.
- The HandleCollision Class is responsible for checking if a bison hits an obstacle.
- The PipeObstacle Class generates the obstacles that the flappy bison will be avoiding and
passing through to gain points. 
- The StartingPage class is a controller class for the opening page of the game that
is responsible for displaying the scene created on Scene Builder that has a start button
that will be pressed to start the game.
- The MainPage class is the generated controller class generated from Scene Builder
that has been modified to have the game begin in this scene. This class has the 
initializations for gaining control of our flappy bison to move with the cursor and has
the code for getting the total number of points the user gets
- The EndPage is the controller class for the scene a user is directed when Appa the Flappy
Bison dies (hits an obstacle). On here is a display of their points earned and a restart
button to play again.


THIRD PARTY LIBRARIES USED: (Include version numbers of all libraries and URLs to the main page for the library)
- JavaFX 19 (2023) (i.e Scenebuilder)


VIDEO URL:
https://mediaspace.bucknell.edu/media/King%27s+Queens+%28CSCI+205%29+Final+Project+Video/1_dehgskeg

## How to run it
In order to build and run this project. A user needs to clean clone the git repository and run
the main 
The way our game works is when run on gradle, it should generate an opening page that displays
the Flappy Bison title and a start button to begin playing the game. Once ready, the user can click on
the start button, and they will gain control of moving the bison by using their cursor. The goal of the game
is to move the Bison through the obstacles that are generated on the right side of the screen and not hit 
them. If the bison hits an obstacle, the game ends and moves to a new scene that has a restart button.
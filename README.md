Intro2CS_ArielU_2026A
Ex2 – Basic Object-Oriented Programming & 2D Maze Algorithms 🚀

This project was developed as part of the Introduction to Computer Science course
during the first year of Computer Science studies
at Ariel University.

The assignment introduces core Object-Oriented Programming (OOP) concepts through
algorithms operating on two-dimensional arrays that represent a maze or an image 🧩.


Project Overview ✨

The project is centered around a 2D map structure implemented using OOP principles.
The map is represented as a grid of integers, where each cell can describe a color,
an obstacle, a distance value, or any other logical marker.

Several classic algorithms are implemented on top of this structure, with a strong
focus on Breadth-First Search (BFS) for solving grid-based problems.

⸻

Main Files and Structure 📂

Ex2_GUI.java
Provides a simple graphical user interface 🎨
Includes static methods for visualizing maps, distances, and fill results.
The GUI is implemented using the StdDraw library.

Index2D.java
Represents a single pixel (x, y) in the map.
Used to locate positions in the grid and to perform distance calculations.

Index2DTest.java
JUnit test class for Index2D.
Verifies correctness of pixel behavior and distance calculations.

Map.java
The core class of the project.
Implements the Map2D interface and contains the main logic and algorithms operating
on the 2D grid, including shortest path and fill algorithms.

Map2D.java
An interface that defines the required behavior of a 2D map.
Serves as a clear contract for the Map class.

MapTest.java
JUnit test class for Map.
Tests map initialization, pixel access, algorithms, and edge cases.

Pixel2D.java
An interface defining the behavior of a pixel in the map.

StdDraw.java
A utility class used for graphical drawing and visualization.

⸻

Implemented Algorithms 🧠

Shortest Path Distance (allDistance)
Computes the shortest distance from a given starting pixel to all reachable pixels
in the map while avoiding obstacles.
The algorithm is based on Breadth-First Search (BFS).
Unreachable cells are marked with the value -1.
Supports both cyclic and non-cyclic maps.

Flood Fill (fill)
Fills the connected component of a given pixel with a new value.
Connectivity is defined using four-directional adjacency.
Returns the number of filled pixels.

⸻

Graphical Visualization 🎯

The GUI allows:
• displaying original maps
• visualizing distance maps
• showing flood fill results

This makes it easier to understand and debug the algorithms visually.

⸻

Screenshots and Results 📸

Below are examples of outputs generated using the Ex2_GUI.
                            

 ⸻                        <img width="513" height="511" alt="צילום מסך 2025-12-28 ב-21 16 57" src="https://github.com/user-attachments/assets/663cf578-66ee-458c-9fd1-a79b7389497c" />


⸻                        <img width="513" height="511" alt="צילום מסך 2025-12-28 ב-21 19 53" src="https://github.com/user-attachments/assets/983d2177-128b-4dce-a582-c54595396b7f" />
  
⸻                        <img width="513" height="511" alt="צילום מסך 2025-12-28 ב-21 19 55" src="https://github.com/user-attachments/assets/9c80277e-1583-4634-8333-d9b234e05c44" />

⸻                         <img width="513" height="511" alt="צילום מסך 2025-12-28 ב-21 19 56" src="https://github.com/user-attachments/assets/e01ad1d8-fbd7-4d04-adf5-95af9f22c3ac" />

⸻                         <img width="513" height="511" alt="צילום מסך 2025-12-28 ב-21 20 27" src="https://github.com/user-attachments/assets/348cf1d5-c730-4e9e-b63d-299f948cc2dd" />


⸻                         <img width="513" height="511" alt="צילום מסך 2025-12-28 ב-21 20 31" src="https://github.com/user-attachments/assets/4bb4987c-443a-4585-ad80-edfa16d9dec2" />
   

⸻                         <img width="513" height="511" alt="צילום מסך 2025-12-28 ב-21 19 30" src="https://github.com/user-attachments/assets/24d562a0-2047-4234-8e63-413c12df409f" />


⸻                         <img width="513" height="511" alt="צילום מסך 2025-12-28 ב-21 19 31" src="https://github.com/user-attachments/assets/afb7c24b-b12d-4d52-8314-631d3feba2bb" />
                                   

⸻                         <img width="513" height="511" alt="צילום מסך 2025-12-28 ב-21 19 34" src="https://github.com/user-attachments/assets/1e63c5b9-839c-43ae-b71b-2c051abfb8ec" />


⸻                         <img width="513" height="511" alt="צילום מסך 2025-12-28 ב-21 19 36" src="https://github.com/user-attachments/assets/57a15f1a-d742-4b23-bab1-2ae8c03b64eb" />


⸻                         <img width="513" height="511" alt="צילום מסך 2025-12-28 ב-21 19 37" src="https://github.com/user-attachments/assets/d4fc4846-8c9b-4f76-afaa-ec62928d7b6a" />
   


Notes 💡

• The project follows the assignment specification and interfaces strictly.
• Emphasis was placed on correctness, clarity, and clean object-oriented design.
• JUnit tests were written for all major components.

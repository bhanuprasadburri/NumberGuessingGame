# 🎯 Number Guessing Game (Java)

A fun and interactive **console-based Number Guessing Game** developed in **Java**. The game challenges players to guess a randomly generated number within a limited number of attempts. It includes multiple difficulty levels, a scoring system, hints, statistics tracking, guess history, and timing features, making it an engaging mini project for learning Java fundamentals.

---

## 📌 Features

* 🎮 Three Difficulty Levels

  * 🟢 Easy (1–100, 5 Attempts)
  * 🟡 Medium (1–250, 7 Attempts)
  * 🔴 Hard (1–500, 9 Attempts)

* 🎯 Random Number Generation using `Random`

* 🏆 Scoring System

* 🥇 High Score Tracking

* 💡 Smart Random Hint System

* 📜 Guess History

* 📊 Game Statistics

  * Games Played
  * Games Won
  * Games Lost
  * Win Percentage

* ⏱ Time Taken to Finish Each Game

* 🔄 Play Again Option

* ⚠ Input Validation

* 😊 Interactive Console Interface with Emojis

---

## 🖥️ Technologies Used

* Java
* Eclipse IDE (or any Java IDE)
* Java Collections (`ArrayList`)
* Object-Oriented Programming (OOP)
* Random Number Generation
* Console-Based User Interface

---

## 📂 Project Structure

```
NumberGuessingGame/
│
├── NumberGuessingGame.java
└── README.md
```

---

## 🚀 How to Run

### Clone the repository

```bash
(https://github.com/bhanuprasadburri/NumberGuessingGame.git)
```

### Navigate to the project

```bash
cd NumberGuessingGame
```

### Compile

```bash
javac NumberGuessingGame.java
```

### Run

```bash
java NumberGuessingGame
```

---

## 🎮 Gameplay

1. Launch the game.
2. Choose a difficulty level.
3. Guess the randomly generated number.
4. Receive feedback:

   * 📈 Too High
   * 📉 Too Low
5. Use hints (if available).
6. Earn points by winning.
7. Try to beat your high score.
8. View statistics and guess history after every game.
9. Play again or exit.

---

## 🏆 Scoring System

| Difficulty | Number Range | Attempts | Reward     |
| ---------- | ------------ | -------- | ---------- |
| Easy       | 1–100        | 5        | +10 Points |
| Medium     | 1–250        | 7        | +20 Points |
| Hard       | 1–500        | 9        | +30 Points |

---

## 💡 Hint System

Players can request hints during gameplay.

Hints may include:

* Even/Odd
* Greater or Less than Half
* Last Digit
* Divisible by 5
* Number Range
* Sum of Digits

Random hints make every game unique.

---

## 📊 Statistics

The game automatically tracks:

* Total Games Played
* Total Wins
* Total Losses
* Win Percentage

---

## 📜 Guess History

Displays every guess made during a game, helping players review their attempts and improve their strategy.

Example:

```
Guess History

15
42
67
81
90
```

---

## ⏱ Timer

The game records the total time taken to complete each round.

Example:

```
Time Taken : 12.45 seconds
```

---

## 🛠 Java Concepts Used

* Classes & Objects
* Methods
* Loops
* Conditional Statements
* Switch Case
* Random Class
* Scanner Class
* ArrayList
* Object-Oriented Programming
* Input Validation
* Exception Prevention

---

## 📸 Sample Output

```
========================================
         🎮 SELECT DIFFICULTY
========================================

1. 🟢 Easy
   Range    : 1-100
   Attempts : 5
   Reward   : +10 Points

2. 🟡 Medium
   Range    : 1-250
   Attempts : 7
   Reward   : +20 Points

3. 🔴 Hard
   Range    : 1-500
   Attempts : 9
   Reward   : +30 Points

========================================

Enter your choice : 2
```

---

## 🎯 Future Enhancements

* 💾 Save High Score using File Handling
* 👥 Two-Player Mode
* 🏅 Achievement System
* 🌈 Colored Console Output
* 🎵 Sound Effects
* 🧠 AI-Based Smart Hint System
* 🌍 Online Leaderboard
* 🎨 GUI Version using Java Swing or JavaFX

---

## 🎓 Learning Outcomes

This project demonstrates practical implementation of:

* Core Java Programming
* Object-Oriented Design
* User Interaction
* Game Logic Development
* Data Structures
* Randomization Techniques
* Console Application Development

---

## 🤝 Contributing

Contributions, suggestions, and improvements are welcome.

1. Fork the repository.
2. Create a new feature branch.
3. Commit your changes.
4. Push your branch.
5. Open a Pull Request.

---

## ⭐ Support

If you found this project helpful, consider giving it a ⭐ on GitHub.

It motivates further improvements and helps others discover the project.

---

## 👨‍💻 Author

**Bhanu Prasad Burri**

If you enjoyed this project, don't forget to ⭐ the repository!

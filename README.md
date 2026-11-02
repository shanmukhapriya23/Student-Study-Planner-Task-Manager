# 📚 Student Study Planner & Task Manager

A lightweight, robust, and intuitive Android application built in Kotlin to help students organize their daily academic tasks, manage study priorities, and track pending coursework efficiently.

## 🚀 Key Highlights
* **Zero Annotation Processor Bloat**: Designed completely with native SQLite and standard Android core components to ensure smooth builds and prevent JDK/Gradle compatibility conflicts.
* **Task Prioritization**: Categorize coursework by urgency and importance (`High`, `Medium`, `Low`).
* **Dynamic Task Tracking**: Real-time task counter updates and interactive completion states using a custom RecyclerView adapter.
* **Clean Architecture**: Organized using standard MVVM (Model-View-ViewModel) patterns and repository layers for clean separation of concerns.

---

## 🛠️ Tech Stack & Architecture
* **Language**: 100% Kotlin
* **UI Framework**: XML Layouts with Material Design Components
* **Local Database**: Native `SQLiteOpenHelper` & Content Values
* **Architecture Components**: ViewModel, LiveData, ViewBinding
* **Build Tool**: Gradle 8.2 / JDK 17

---

com.example.studentstudyplandermaskmanger/
│
├── data/
│   ├── TaskEntity.kt         # Standard data model class
│   ├── TaskDbHelper.kt       # Native SQLite database helper
│   ├── TaskDao.kt            # Data access object wrapper
│   └── TaskRepository.kt     # Repository abstraction layer
│
├── viewmodel/
│   └── TaskViewModel.kt      # ViewModel managing UI LiveData states
│
├── ui/
│   ├── TaskAdapter.kt        # RecyclerView adapter for task lists
│   └── TaskViewHolder.kt     # ViewHolder bindings for task items
│
└── MainActivity.kt           # Main application entry point & event handlers

## 📱 App UI Preview
| Dashboard View | Task Item Card |
| :---: | :---: |
| *Clean Material Design layout with input forms and task summary counter.* | *CardView list item with subject tag, priority indicator, and status checkbox.* |

---

## ⚙️ Step-by-Step Setup & Installation

1. **Clone the Repository**:
   ```bash
   git clone [https://github.com/your-username/student-study-planner.git](https://github.com/your-username/student-study-planner.git)

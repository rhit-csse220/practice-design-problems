# Libraries

## System Description
In a specific city, there are multiple libraries all of whom use the same system to manage their book records.  But it is often the case that the different branches will have copies of the same book.  In these cases, the system manages two objects - a BookRecord which stores book data like title and author, and BookCopy which represents a physical book that's available for borrowing.  Each book copy is tagged with a unique tag id number which is used to determine which branch the book ought to be shipped to when it is returned.

## Solution A
![Solution A UML Diagram](Libraries.png)

[PlantUML link](https://www.plantuml.com/plantuml/img/VP0n3i8m34NtdC9Y0gHUW86XJ4Z0WBY0srXjr2H6JgggghWxJO4M5XR7yd_v_abeZB-Ze8CGUqjZ5LF6rbcbIeiXm1cDXm7KupCucK9G-bpGbpKC2g2OsWiwIjGRovcRAvKiUcAYYPR64zjOiqmiW0avYt176dPGC5j2lonA3WU-z-FzYk8j6QmtAc9rr0cQvIpRmuexJphlLx_nr9G-wTj_of9LVSNEPYsj6HzM6qsl_t3a2fBm1000)

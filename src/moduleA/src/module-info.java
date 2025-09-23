/**
 *
 project-root
 ├─ moduleA
 │   ├─ module-info.java
 │   └─ com/example/a/Hello.java
 └─ moduleB (requires moduleA)
 ├─ module-info.java
 └─ com/example/b/App.java
 */

module moduleA {
    exports com.example.a;
}
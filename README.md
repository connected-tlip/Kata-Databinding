# Android Data-Binding

(Alternatively: Developing View Logic Using TDD)

Due to its proximity to the UI, view logic is typically difficult to test without resorting to UI tests or headless-rendering-based libraries like [Robolectric](http://robolectric.org/).

This Kata is an introduction of the usage of the [Android Data-Binding Library](https://developer.android.com/topic/libraries/data-binding/index.html). Using 2-way data-binding, we will learn how you can test view logic with only JUnit, and develop your view logic using TDD.

## Problem Description

This project contains a simple single-screen app. Using TDD, we will develop the logic for that screen.

[activity_main.xml](app/src/main/res/layout/activity_main.xml) is a databinding-enabled XML layout, driven by the [MainViewLogic](./app/src/main/java/com/connectedlab/kata4/MainViewLogic.kt) class.

We will be writing tests for [MainViewLogic](./app/src/main/java/com/connectedlab/kata4/MainViewLogic.kt).

Implement each story described in the comments of [MainViewLogicTest](./app/src/test/java/com/connectedlab/kata4/MainViewLogicTest.kt). Start by coming up with the test, then make your test pass by implementing the corresponding function in MainViewLogic. Finally, modify the XML to make use of the fields in MainViewLogic.

## Third Party Libraries

We will use [Mockito](http://site.mockito.org/) for mocking.

Not 3rd party anymore, but we almost make extensive use of the [Android Data-Binding Library](https://developer.android.com/topic/libraries/data-binding/index.html).
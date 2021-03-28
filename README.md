# Survey Example
A friend in school showed me an old assignment he did for class and asked what it would look like if we were writing it in production.

It was a simple CLI script that asks the user for a few inputs from a predetermined file folder, and generates files with the results.
So obviously, I over-engineered it.
I decided to break it down in an MVP pattern with Coroutines, Koin, and Okio.

## Main
The [main.kt](https://github.com/r2vq/SurveyAssignment/blob/main/src/main/kotlin/main.kt) is the entry to the application.
This sets up the DI and creates the Application.

## Application
Although we could use constructor injection here, I decided to make the [Application](https://github.com/r2vq/SurveyAssignment/blob/main/src/main/kotlin/com/keanequibilan/coursereader/Application.kt) a KoinComponent instead.
This is because with some frameworks, like Android, we don't have control over our Application's constructor.
This pattern works with that constraint in mind.

## Dependency Injection
I decided to go with Koin for the DI Library.

![Modules](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/r2vq/SurveyAssignment/main/modules.iuml)

I instantiate the components in modules ([Presenter](https://github.com/r2vq/SurveyAssignment/blob/main/src/main/kotlin/com/keanequibilan/coursereader/presenter/PresenterModule.kt), [File Reader](https://github.com/r2vq/SurveyAssignment/blob/main/src/main/kotlin/com/keanequibilan/coursereader/reader/FileReaderModule.kt), [Repository](https://github.com/r2vq/SurveyAssignment/blob/main/src/main/kotlin/com/keanequibilan/coursereader/repo/RepositoryModule.kt), [View](https://github.com/r2vq/SurveyAssignment/blob/main/src/main/kotlin/com/keanequibilan/coursereader/view/ViewModule.kt)), join them in the [DI Module](https://github.com/r2vq/SurveyAssignment/blob/main/src/main/kotlin/com/keanequibilan/coursereader/di/AppModule.kt), and add start Koin with all of them in the [main](https://github.com/r2vq/SurveyAssignment/blob/main/src/main/kotlin/main.kt) method.
For something this simple, I could have put all the definitions in one module, but decided to keep them separate to mimic a multi-module project.
Something to note here is that I define interfaces for any of the injectable classes and instantiate implementations of them.
This is so any callers have no concern *how* a function is managed, the name, its parameters, and its return type.

## Model-View-Presenter
The [View](https://github.com/r2vq/SurveyAssignment/blob/main/src/main/kotlin/com/keanequibilan/coursereader/view/View.kt) class in MVP is super thin.
Normally you use this class to bind data to views and receive user input to pass to the Presenter.
Because this is a CLI app, the view is even thinner: It just has methods for writing messages and receiving user input.

The [Presenter](https://github.com/r2vq/SurveyAssignment/blob/main/src/main/kotlin/com/keanequibilan/coursereader/presenter/Presenter.kt) is what is doing the real work.
In a real MVP app, we'd have the Presenter delegate to the Model layer user input, and it would delegate to the View and data from the Model.
Because this is such a simple app, I decided to keep the business logic in the Presenter and create a [Repository](https://github.com/r2vq/SurveyAssignment/blob/main/src/main/kotlin/com/keanequibilan/coursereader/repo/Repository.kt) instead.

## Repository
This traditionally abstracts away the data-source so callers don't know where they're coming from (DB? IO? Network?).
There's only one data source in this app, so a repository isn't exactly necessary, but it's managing all the file IO.
It uses the [Reader](https://github.com/r2vq/SurveyAssignment/blob/main/src/main/kotlin/com/keanequibilan/coursereader/reader/FileReader.kt) class to write and read from files.
# About
This is sample project for reporting an issue with R8 when used during Android library publication.

## Details
When Kotlin `interface` contains a `companion object` with `operator fun invoke()` it can
be easily instantiated e.g.: `MyInterface()`

If you apply the minification to the published artifact (for instance when you want to discourage usage of internal APIs),
and also apply `@JvmName()` with some Java friendly method name, the original `invoke()` will be removed (probably inlined)
by the minification process and will be only available from Java classes via the new name.

Also this only happens for the published artifact, the issue is not present if you add direct dependency
on the affected library module in the project, since the minification will detekt direct usage of the
`invoke()` operator.

The removal of the `invoke()` operator happens despite usage of the `@Keep` annotation.

## Example
For successful reproduction of the issue in the ExampleUnitTest in the app module,
you first need to publish the mylibrary module to the Maven Local repository.
Just run `mylibrary:publishToMavenLocal` gradle task.
After that you can run tests in the `ExampleUnitTest` class.
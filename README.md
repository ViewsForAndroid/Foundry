# Foundry: The missing typekit for Android

**NOTE**: Currently a work in progress! Don't even compile very well yet as I'm adapting this project!

Tired of manually setting the typefaces of all your views and cluttering your logic with presentation code? Foundry has your back.

Foundry lets you style the typefaces of your views in your XML layout files and styles.

Foundry currently supports `ttf` fonts only, although you may use a different extension if required.

You can try out the sample application:

### Using Foundry

**Note:** Until Foundry is released on Maven Central, you will need to build the library yourself in order to use it in your own projects. See `Building Foundry: Install` for more information.

**1. Add Foundry as a Dependency**

	dependencies {
		compile 'com.viewsforandroid.foundry:1.0.0'
	}

**2. Add Typefaces to your Project**

Place your custom `ttf` fonts in your assets directory.

**3. Use Foundry as your LayoutInflater**

You can either manually create a `FoundryLayoutInflater` as required, or you can use Foundry as your default inflater views by adding the following code to your `Activity` classes:

	private LayoutInflater foundryLayoutInflater;

	@Override
	public Object getSystemService(final String name) {
		if (Context.LAYOUT_INFLATER_SERVICE.equals(name)) {
			return getFoundryLayoutInflater();
		}
		return super.getSystemService(name);
	}

	private LayoutInflater getFoundryLayoutInflater() {
		if (foundryLayoutInflater == null) {
			foundryLayoutInflater = new FoundryLayoutInflater(this, new FoundryFoundry(getAssets()))
		}
		return foundryLayoutInflater;
	}

**4. Apply Foundry to your Layouts**

Add the following to the root view in your layout file:

	xmlns:foundry="http://schemas.android.com/apk/res-auto"

Add `foundry:typeface` attributes to your views:

	<TextView
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:text="Sample Text"
		foundry:typeface="font_name"/>

The `font_name` should match the name of your font file without the `.ttf` extension.

**Note:** you can leverage Foundry in your styles by using the `typeface` attribute without any prefix, e.g:

	<resources>
		<style name="StyledByFoundry">
			<item name="typeface">font_name</item>
		</style>
	</resources>

Foundry cannot be used inside text styles that are applied using `android:textAppearance`.

### Building Foundry

**Requirements:**

* JDK 7

#### Compile

Builds Foundry, the sample app and runs unit tests.

	$ ./gradlew clean assemble

## TODO

 - Restore tests with Robolectric as Joseph Earl was using Maven.

## Acknowledgments

Thanks to Joseph Earl for starting writing this beautiful piece of code.

## License

	Copyright 2014 Joseph Earl.
	Copyright 2014 Aldo Borrero.

	Licensed under the Apache License, Version 2.0 (the "License"); you may not use
	this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software distributed
	under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
	CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and limitations
	under the License.

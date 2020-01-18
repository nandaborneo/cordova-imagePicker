cordova-imagePicker
===================

Cordova Plugin For Multiple Image Selection - implemented for iOS and Android 4.0 and above.

Demo app https://github.com/nandaborneo/demo-ionic

UPDATED FEATURE
===================
## Previous selected image can be selected if sending the previous object in JSON
### Example
please see the demo app for full example
```javascript
openImagePicker(previewPhotos = null){
    var options = {
      maximumImagesCount: -1,
      listPrevious: JSON.stringify(previewPhotos) ? previewPhotos : "" => This line added previous object and convert to json
    }
    console.log(JSON.stringify(previewPhotos));
    this.imagePicker.getPictures(options)
    .then((results) => {
      for (var i = 0;i<results.length;i++){
        var data:any = {};
        data.filename = results[i].substring(results[i]
          .lastIndexOf('/')+1);
        data.path = results[i];
        this.previewPhotos.push(data);
        for( var ii = 0; ii < this.previewPhotos.length; ii++){
          this.previewPhotos[ii]['info'] = "Gambar "+(ii+1)+" dari "+this.previewPhotos.length
        }
      }
      console.log(this.previewPhotos)
      
    }, (err) => { console.log(err) });
  }
```

## Installing the plugin

The plugin conforms to the Cordova plugin specification, it can be installed
using the Cordova / Phonegap command line interface.

    ionic cordova plugin add https://github.com/nandaborneo/cordova-imagePicker.git
    
    npm install @ionic-native/image-picker@4 => for ionic 2/3


## Using the plugin

The plugin creates the object `window.imagePicker` with the method `getPictures(success, fail, options)`

Example - Get Full Size Images (all default options):
```javascript
window.imagePicker.getPictures(
	function(results) {
		for (var i = 0; i < results.length; i++) {
			console.log('Image URI: ' + results[i]);
		}
	}, function (error) {
		console.log('Error: ' + error);
	}
);
```

Example - Get at most 10 images scaled to width of 800:
```javascript
window.imagePicker.getPictures(
	function(results) {
		for (var i = 0; i < results.length; i++) {
			console.log('Image URI: ' + results[i]);
		}
	}, function (error) {
		console.log('Error: ' + error);
	}, {
		maximumImagesCount: 10,
		width: 800
	}
);
```

### Options

    options = {
        // max images to be selected, defaults to 15. If this is set to 1, upon
    	// selection of a single image, the plugin will return it.
    	maximumImagesCount: int,
    	
    	// max width and height to allow the images to be.  Will keep aspect
    	// ratio no matter what.  So if both are 800, the returned image
    	// will be at most 800 pixels wide and 800 pixels tall.  If the width is
    	// 800 and height 0 the image will be 800 pixels wide if the source
    	// is at least that wide.
    	width: int,
    	height: int,
    	
    	// quality of resized image, defaults to 100
    	quality: int (0-100)
    };
	
### iOS 10 issues

Starting from iOS 10, Apple started asking for specifying the reason for accessing the user’s photo library, therefore it's mandatory to add `NSPhotoLibraryUsageDescription` entry in the info.plist.

[`NSPhotoLibraryUsageDescription`](https://developer.apple.com/library/mac/documentation/General/Reference/InfoPlistKeyReference/Articles/CocoaKeys.html#//apple_ref/doc/uid/TP40009251-SW17) describes the reason that the app accesses the user’s photo library. When the system prompts the user to allow access, this string is displayed as part of the dialog box. In order to add this entry you must pass the variable `PHOTO_LIBRARY_USAGE_DESCRIPTION` on plugin install.

Example:
 
`cordova plugin add cordova-plugin-image-picker --variable PHOTO_LIBRARY_USAGE_DESCRIPTION="your message"`

Empty string will be added as value if you dont pass the variable 
    
### Note for Android Use

The plugin returns images that are stored in a temporary directory.  These images will often not be deleted automatically though.  The files should be moved or deleted after you get their filepaths in javascript.

## Libraries used

#### ELCImagePicker

For iOS this plugin uses the ELCImagePickerController, with slight modifications for the iOS image picker.  ELCImagePicker uses the MIT License which can be found in the file LICENSE.

https://github.com/B-Sides/ELCImagePickerController

#### MultiImageChooser

For Android this plugin uses MultiImageChooser, with modifications.  MultiImageChooser uses the BSD 2-Clause License which can be found in the file BSD_LICENSE.  Some code inside MultImageChooser is licensed under the Apache license which can be found in the file APACHE_LICENSE.

https://github.com/derosa/MultiImageChooser

#### FakeR

Code(FakeR) was also taken from the phonegap BarCodeScanner plugin.  This code uses the MIT license.

https://github.com/wildabeast/BarcodeScanner

## License

The MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

/**
 * Created by Weiwei on 2015/3/14.
 */

module.exports = function(grunt) {

    // CONFIGURE GRUNT

    grunt.initConfig({

        // get the configuration info from package.json
        pkg: grunt.file.readJSON('package.json'),

        // configure jshint to validate js files
        jshint: {
            options: {
                reporter: require('jshint-stylish') // use jshint-stylish to make our errors look and read good
            },

            // when this task is run, lint the Gruntfile and all js files in src
            build: ['Gruntfile.js', 'src/**/*.js']
        },

        // configure uglify to minify js files
        uglify: {
            options: {
                // this will add a nice comment to the top of our minified file
                banner: '/*\n <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> \n*/\n'
            },

            dev: {
                files: { 'dist/js/magic.min.js': ['src/js/magic.js', 'src/js/magic2.js'] }
            },

            production: {
                files: { 'dist/js/magic.min.js': 'src/**/*.js' }
            }
        },

        // compile less stylesheets to css
        less: {
            build: {
                files: {
                    'dist/css/style.css': 'src/css/pretty.less'
                }
            }
        },

        // configure cssmin to minify css files
        cssmin: {
            options: {
                banner: '/*\n <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> \n*/\n'
            },

            build: {
                files: {
                    'dist/css/style.min.css': 'src/css/style.css'
                }
            }
        },

        // configure watch to auto update
        watch: {

            // for stylesheets, watch css and less files
            // only run less and cssmin stylesheets
            files: ['src//*.css', 'src//*.less'],
            tasks: ['less', 'cssmin'],

            // for scripts, run jshint and uglify
            script: {
                files: 'src/**/*.js', tasks: ['jshint', 'uglify']
            }
        }

    });


    // LOAD GRUNT PLUGINS

    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-watch');

    // CREATE TASKS
    // this default task will go through all configuration (dev and production) in each task
    grunt.registerTask('default', ['jshint', 'uglify', 'cssmin', 'less']);

    // this task will only run the dev configuration
    grunt.registerTask('dev', ['jshint:dev', 'uglify:dev', 'cssmin:dev', 'less:dev']);

    // this task will only run the dev configuration
    grunt.registerTask('production', ['jshint:production', 'uglify:production', 'cssmin:production', 'less:production']);
};
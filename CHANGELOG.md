# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## [Unreleased]

## [2024.12.3]

### Added

- Designed test suite for Permission component in `PermissionTest`
- Designed two different use cases for Permission component in `PermissionDemo`
- clearSet() method in `PermissionSecondary` to makesure the test runs successfully

### Updated

- modify the constructor of Permission1.java
- move the components into components package.
- move the `@Convention` and `@Correspondence` from `PermissionSecondary` to `Permission1`

## [2024.11.24]

### Added

- Designed kernel implementation for Permission component
- Added two secondary method setName and setDescription in `Permission1` and `PermissionKernel`
- Added three static methods in abstract class `PermissionSecondary` called checkUniqueness and removeFromSet and addToSet.

### Updated

- Changed design to include the convention and correspondence included in `PermissionSecondary`

## [2024.11.4]

### Added

- Updated A main method for invoking methods of Permission class
- implement Standard method in Permission1 class, with clear(),newInstance(),transferFrom(Permission arg0)
- Added abstract class of PermissionSecondary, and implement equals(Object o),toString(),hashCode() by using the kernel methods only .

## [2024.10.16]

### Added

- Updated A main method for invoking methods of Permission class
- rename PermissionKernel -> PermissionKernel
- rename PermissionSecondary -> Permission
- rename Permission -> Permission1
- modify javadocs for Permission and PermissionKernel
- make PermissionKernel extends Standard

## [2024.10.03]

### Added

- Updated a Command component
- Updated a User component
- Updated a Permission component
- Designed a proof of concept for Permission component

## [2024.10.02]

### Added

- Designed a Command component
- Designed a User component
- Designed a Permission component

## [2024.08.07]

### Added

- Added `/bin` to `.gitignore`, so binaries are no longer committed
- Added the TODO tree extensions to `extensions.json`
- Added the `todo-tree.general.showActivityBarBadge` setting to `settings.json`
- Added the `todo-tree.tree.showCountsInTree` setting to `settings.json`
- Added the VSCode PDF extension to `extensions.json`
- Added `java.debug.settings.vmArgs` setting to enable assertions (i.e., `-ea`)
- Added information about making branches to all parts of the project
- Added information about how to update the CHANGELOG to every part of the
  project
- Added information about how to make a pull request to every part of the
  project

### Changed

- Updated `settings.json` to format document on save using `editor.formatOnSave`
  setting
- Updated `settings.json` to exclude certain files from markdown to PDF
  generation using `markdown-pdf.convertOnSaveExclude` setting
- Updated `settings.json` to use latest `java.cleanup.actions` setting
- Updated `settings.json` to automatically choose line endings using `files.eol`
  setting
- Updated `settings.json` to organize imports automatically on save using the
  `editor.codeActionsOnSave` and `source.organizeImports` settings
- Changed the component brainstorming assignment to ask a few clarifying
  questions
- Changed the component brainstorming example from `Point3D` to `NaturalNumber`
  to avoid the getter/setter trend
- Updated assignment feedback sections to include a link to a survey that
  I'll actually review
- Updated README to include step about using template repo
- Updated part 3 rubric to include a hierarchy diagram
- Updated part 6 rubric to account for overall polish

### Fixed

- Fixed issue where checkstyle paths would not work on MacOS

### Removed

- Removed `java.saveActions.organizeImports` setting from `settings.json`
- Removed references to `Point3D` completely

## [2024.01.07]

### Added

- Added a list of extensions to capture the ideal student experience
- Added PDFs to the `.gitignore`
- Added the OSU checkstyle config file
- Added the OSU formatter config file
- Added a `settings.json` file to customize the student experience
- Created a README at the root to explain how to use the template repo
- Created initial drafts of the six portfolio assessments
- Added READMEs to key folders like `test` and `lib` to explain their purpose

[unreleased]: https://github.com/jrg94/portfolio-project/compare/v2024.08.07...HEAD
[2024.08.07]: https://github.com/jrg94/portfolio-project/compare/v2024.01.07...v2024.08.07
[2024.01.07]: https://github.com/jrg94/portfolio-project/releases/tag/v2024.01.07

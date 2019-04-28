-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 28, 2019 at 02:53 PM
-- Server version: 5.7.25-0ubuntu0.18.04.2
-- PHP Version: 7.2.17-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mcq`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `teacherId` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `name`, `teacherId`) VALUES
(3, 'filmology', 4),
(47, 'food and nutrition', 4),
(49, 'art and science', 4);

-- --------------------------------------------------------

--
-- Table structure for table `course_student`
--

CREATE TABLE `course_student` (
  `id` int(100) NOT NULL,
  `courseId` int(100) NOT NULL,
  `studentId` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `id` int(100) NOT NULL,
  `courseId` int(100) NOT NULL,
  `Description` varchar(200) NOT NULL,
  `isPublished` tinyint(1) NOT NULL DEFAULT '0',
  `Duration` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `exam_question`
--

CREATE TABLE `exam_question` (
  `id` int(100) NOT NULL,
  `examId` int(100) NOT NULL,
  `questionId` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE `marks` (
  `id` int(10) NOT NULL,
  `examId` int(10) NOT NULL,
  `studentId` int(10) NOT NULL,
  `marks` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`id`, `examId`, `studentId`, `marks`) VALUES
(18, 31, 2, 20),
(19, 31, 6, 20),
(20, 42, 13, 0),
(21, 42, 13, 1);

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `id` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  `description` varchar(200) NOT NULL,
  `choiceOne` varchar(200) NOT NULL,
  `choiceTwo` varchar(200) NOT NULL,
  `choiceThree` varchar(200) NOT NULL,
  `choiceFour` varchar(200) NOT NULL,
  `correctChoice` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `courseId`, `description`, `choiceOne`, `choiceTwo`, `choiceThree`, `choiceFour`, `correctChoice`) VALUES
(5, 3, 'who is the director of lost in translation?', 'mark jaka', 'tim burton', 'sofia cappola', 'sophie turner', 'sofia cappola'),
(6, 3, 'on which of the the year pakistan film society was made?', '1953', '1963', '1981', '1950', '1963'),
(7, 3, '\'empire of the sun\' is a film by-', 'steven spielberg', 'christopher nolan', 'david fincher', 'paul thomas anderson', 'steven spielberg'),
(8, 3, 'netflix \'sacred games\' original reflected the life of which hooligan of india?', 'haji mastan', 'karim lala', 'dawood ibrahim', 'ganesh gaitonde', 'ganesh gaitonde'),
(9, 3, 'who is playing the central cast of \'joker\'(2019)?', 'steve blum', 'heath ledger', 'jared leto', 'joaquin phoenix', 'joaquin phoenix'),
(10, 3, '76th golden globe held in which year?', '2017', '2013', '2018', '2005', '2018'),
(11, 3, 'the film followed by the novel\'unbearable lightness of being\' was based on which historical circumstance?', 'the labor movement', 'scandinavian revival', 'czechoslovak period', 'suffragists\' movement by women', 'czechoslovak period'),
(12, 3, 'tarkovsky\'s first feature film was-', 'the killers', 'ivan\'s childhood', 'andrei rublev', 'solaris', 'ivan\'s childhood'),
(13, 3, 'what is the full name of charlie chaplin?', 'alfred charlie joseph chaplin', 'charlie frank chaplin', 'charles spencer chaplin', 'charles frank chaplin', 'charles spencer chaplin'),
(14, 3, 'padatik was diected by noted parallel cinema director-', 'ritwik ghatak', 'tapan sinha', 'mrinal sen', 'shyan benegal', 'mrinal sen'),
(15, 3, '\'live from dhaka\' is a debut film by', 'srijit mukherjee', 'mostofa sarwar farooky', 'abdullah mohammad saad', 'tauquir ahmed', 'abdullah mohammad saad'),
(22, 47, 'The United States Department of Agriculture’s Daily Food Guide suggests that the Fats, Oils and Sweets Group be used ___', 'once a week', 'four times a day', 'never on Sundays', 'sparingly', 'sparingly'),
(23, 47, 'Which vitamin is needed to prevent a birth defect called Spina Bifida', 'Vitamin D', 'Vitamin A', 'Folate', 'Vitamin E', 'Folate'),
(24, 47, 'Which of the following nutrients is known as the sunshine vitamin?', 'Vitamin C', 'Vitamin A', 'Vitamin K', 'Vitamin D', 'Vitamin D'),
(25, 47, 'Which of the following nutrients is needed to build and maintain the structuralcomponents of the body?', 'Carbohydrates', 'Protein', 'Fat', 'Fiber', 'Protein');

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `id` int(100) NOT NULL,
  `courseId` int(100) NOT NULL,
  `studentId` int(100) NOT NULL,
  `isAccepted` int(10) NOT NULL DEFAULT '0',
  `isRejected` int(10) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(120) NOT NULL,
  `password` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `password`) VALUES
(1, 'jafor islam', 'ji'),
(2, 'ekramul', 'e');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `id` int(100) NOT NULL,
  `name` varchar(120) NOT NULL,
  `password` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`id`, `name`, `password`) VALUES
(1, 'z', 'z'),
(2, 'mobarak hossain', 'mh'),
(4, 'rafiqul islam', 'rf');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`),
  ADD KEY `teacher_id` (`teacherId`);

--
-- Indexes for table `course_student`
--
ALTER TABLE `course_student`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_course_course` (`courseId`),
  ADD KEY `fk_course_student` (`studentId`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_course_exam` (`courseId`);

--
-- Indexes for table `exam_question`
--
ALTER TABLE `exam_question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_exam_question` (`examId`),
  ADD KEY `fk_exam_question_question_id` (`questionId`);

--
-- Indexes for table `marks`
--
ALTER TABLE `marks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_exam_marks` (`examId`),
  ADD KEY `fk_marks_student` (`studentId`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_course_question` (`courseId`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_request_course` (`courseId`),
  ADD KEY `fk_request_student` (`studentId`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
--
-- AUTO_INCREMENT for table `course_student`
--
ALTER TABLE `course_student`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `exam`
--
ALTER TABLE `exam`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT for table `exam_question`
--
ALTER TABLE `exam_question`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=162;
--
-- AUTO_INCREMENT for table `marks`
--
ALTER TABLE `marks`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `request`
--
ALTER TABLE `request`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `fk_course_teacher` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `course_student`
--
ALTER TABLE `course_student`
  ADD CONSTRAINT `fk_course_course` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`),
  ADD CONSTRAINT `fk_course_student` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`);

--
-- Constraints for table `exam`
--
ALTER TABLE `exam`
  ADD CONSTRAINT `fk_course_exam` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `exam_question`
--
ALTER TABLE `exam_question`
  ADD CONSTRAINT `fk_exam_question` FOREIGN KEY (`examId`) REFERENCES `exam` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_exam_question_question_id` FOREIGN KEY (`questionId`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `fk_course_question` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`);

--
-- Constraints for table `request`
--
ALTER TABLE `request`
  ADD CONSTRAINT `fk_request_course` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`),
  ADD CONSTRAINT `fk_request_student` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

USE [master]
GO
/****** Object:  Database [HomeStay]    Script Date: 25/08/2019 7:33:03 CH ******/
CREATE DATABASE [HomeStay]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'HomeStay', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\HomeStay.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'HomeStay_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\HomeStay_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [HomeStay] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [HomeStay].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [HomeStay] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [HomeStay] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [HomeStay] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [HomeStay] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [HomeStay] SET ARITHABORT OFF 
GO
ALTER DATABASE [HomeStay] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [HomeStay] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [HomeStay] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [HomeStay] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [HomeStay] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [HomeStay] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [HomeStay] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [HomeStay] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [HomeStay] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [HomeStay] SET  DISABLE_BROKER 
GO
ALTER DATABASE [HomeStay] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [HomeStay] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [HomeStay] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [HomeStay] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [HomeStay] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [HomeStay] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [HomeStay] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [HomeStay] SET RECOVERY FULL 
GO
ALTER DATABASE [HomeStay] SET  MULTI_USER 
GO
ALTER DATABASE [HomeStay] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [HomeStay] SET DB_CHAINING OFF 
GO
ALTER DATABASE [HomeStay] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [HomeStay] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [HomeStay] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'HomeStay', N'ON'
GO
USE [HomeStay]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 25/08/2019 7:33:03 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Account](
	[Username] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[Fullname] [nvarchar](100) NOT NULL,
	[Email] [varchar](100) NOT NULL,
	[Phone] [nchar](11) NOT NULL,
	[Gender] [bit] NULL,
	[IDNumber] [varchar](9) NOT NULL,
	[Nationality] [nvarchar](50) NULL,
	[DOB] [date] NULL,
	[Role] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Accounts] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[BookingInvoice]    Script Date: 25/08/2019 7:33:03 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BookingInvoice](
	[BookingID] [varchar](10) NOT NULL,
	[BookingDate] [date] NULL,
	[StartingDate] [date] NULL,
	[EndingDate] [date] NULL,
	[DayQuantity] [int] NULL,
	[Total] [float] NULL,
	[Username] [varchar](50) NULL,
	[DiscountCode] [varchar](20) NULL,
 CONSTRAINT [PK_Booking] PRIMARY KEY CLUSTERED 
(
	[BookingID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Discount]    Script Date: 25/08/2019 7:33:03 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Discount](
	[DiscountCode] [varchar](20) NOT NULL,
	[DiscountPercent] [float] NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_Discount] PRIMARY KEY CLUSTERED 
(
	[DiscountCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Drink]    Script Date: 25/08/2019 7:33:03 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Drink](
	[DrinkID] [varchar](10) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Description] [nvarchar](500) NULL,
	[Price] [float] NULL,
	[Status] [int] NULL,
 CONSTRAINT [PK_Drink] PRIMARY KEY CLUSTERED 
(
	[DrinkID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Food]    Script Date: 25/08/2019 7:33:03 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Food](
	[FoodID] [varchar](10) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Description] [nvarchar](500) NULL,
	[Price] [float] NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_Food] PRIMARY KEY CLUSTERED 
(
	[FoodID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Invoice_Drink_Details]    Script Date: 25/08/2019 7:33:03 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Invoice_Drink_Details](
	[BookingID] [varchar](10) NULL,
	[DrinkID] [varchar](10) NULL,
	[Quantity] [int] NULL,
	[Price] [float] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Invoice_Food_Details]    Script Date: 25/08/2019 7:33:03 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Invoice_Food_Details](
	[BookingID] [varchar](10) NULL,
	[FoodID] [varchar](10) NULL,
	[Quantity] [int] NULL,
	[Price] [float] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Invoice_Room_Details]    Script Date: 25/08/2019 7:33:03 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Invoice_Room_Details](
	[RoomID] [varchar](10) NULL,
	[BookingID] [varchar](10) NULL,
	[Price] [float] NULL,
	[Quantity] [int] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Invoice_Service_Details]    Script Date: 25/08/2019 7:33:03 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Invoice_Service_Details](
	[BookingID] [varchar](10) NULL,
	[ServiceID] [varchar](10) NULL,
	[DateService] [date] NULL,
	[Price] [float] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Room]    Script Date: 25/08/2019 7:33:03 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Room](
	[RoomID] [varchar](10) NOT NULL,
	[RoomType] [varchar](50) NOT NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_Room] PRIMARY KEY CLUSTERED 
(
	[RoomID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Room_Type]    Script Date: 25/08/2019 7:33:03 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Room_Type](
	[RoomType] [varchar](50) NOT NULL,
	[Description] [nvarchar](500) NULL,
	[Quantity] [int] NULL,
	[Capacity] [int] NULL,
	[Price] [float] NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_RoomType] PRIMARY KEY CLUSTERED 
(
	[RoomType] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Service]    Script Date: 25/08/2019 7:33:03 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Service](
	[ServiceID] [varchar](10) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Price] [float] NULL,
	[Description] [nvarchar](500) NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_Service] PRIMARY KEY CLUSTERED 
(
	[ServiceID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Account] ([Username], [Password], [Fullname], [Email], [Phone], [Gender], [IDNumber], [Nationality], [DOB], [Role]) VALUES (N'admin1', N'1', N'David Beckhamm', N'beckham123@gmail.com', N'39320156822', 0, N'338264985', N'UK', CAST(N'1980-02-04' AS Date), N'admin     ')
INSERT [dbo].[Account] ([Username], [Password], [Fullname], [Email], [Phone], [Gender], [IDNumber], [Nationality], [DOB], [Role]) VALUES (N'admin2', N'1', N'Cristiano Ronaldo', N'cr7@gmail.com', N'39320156024', 0, N'338264984', N'Portugal', CAST(N'1988-02-20' AS Date), N'admin     ')
INSERT [dbo].[Account] ([Username], [Password], [Fullname], [Email], [Phone], [Gender], [IDNumber], [Nationality], [DOB], [Role]) VALUES (N'admin3', N'1', N'Erik Catona', N'catona7@gmail.com', N'39320156127', 0, N'338264983', N'France', CAST(N'1968-07-02' AS Date), N'admin     ')
INSERT [dbo].[Account] ([Username], [Password], [Fullname], [Email], [Phone], [Gender], [IDNumber], [Nationality], [DOB], [Role]) VALUES (N'admin4', N'1', N'Eden Hazard', N'hazardeden123@gmail.com', N'39320156224', 0, N'338264982', N'Belgium', CAST(N'1992-11-15' AS Date), N'admin     ')
INSERT [dbo].[Account] ([Username], [Password], [Fullname], [Email], [Phone], [Gender], [IDNumber], [Nationality], [DOB], [Role]) VALUES (N'admin5', N'1', N'Camila Cabello', N'camila22@gmail.com', N'39320156701', 1, N'338264989', N'US', CAST(N'1997-02-06' AS Date), N'admin     ')
INSERT [dbo].[Account] ([Username], [Password], [Fullname], [Email], [Phone], [Gender], [IDNumber], [Nationality], [DOB], [Role]) VALUES (N'admin8', N'1', N'Dong Nguyen', N'hieule@gmail.com', N'12345678991', 0, N'123475678', N'Vietnam', CAST(N'1999-07-22' AS Date), N'admin     ')
INSERT [dbo].[Account] ([Username], [Password], [Fullname], [Email], [Phone], [Gender], [IDNumber], [Nationality], [DOB], [Role]) VALUES (N'bellerin', N'1', N'Hector Bellerin', N'bellerin2@gmail.com', N'89632161623', 0, N'245318902', N'Spain', CAST(N'1995-03-19' AS Date), N'customer  ')
INSERT [dbo].[Account] ([Username], [Password], [Fullname], [Email], [Phone], [Gender], [IDNumber], [Nationality], [DOB], [Role]) VALUES (N'berndleno', N'1', N'Belo Leno', N'leno1@gmail.com', N'89632153610', 0, N'245318956', N'Germany', CAST(N'1992-03-04' AS Date), N'customer  ')
INSERT [dbo].[Account] ([Username], [Password], [Fullname], [Email], [Phone], [Gender], [IDNumber], [Nationality], [DOB], [Role]) VALUES (N'pepe15', N'1', N'Nicolas Pepe', N'pepe15@gmail.com', N'8963211124 ', 0, N'245318912', N'France', CAST(N'1995-05-29' AS Date), N'customer  ')
INSERT [dbo].[Account] ([Username], [Password], [Fullname], [Email], [Phone], [Gender], [IDNumber], [Nationality], [DOB], [Role]) VALUES (N'staff1', N'1', N'Edison Cavani', N'ecavani213@gmail.com', N'97596632185', 0, N'152515166', N'Uruguay', CAST(N'1985-10-11' AS Date), N'staff     ')
INSERT [dbo].[Account] ([Username], [Password], [Fullname], [Email], [Phone], [Gender], [IDNumber], [Nationality], [DOB], [Role]) VALUES (N'staff10', N'1', N'Truong Quoc Phong', N'phongtruong@gmail.com', N'12345678991', 0, N'741258963', N'Germany', CAST(N'1996-02-02' AS Date), N'staff     ')
INSERT [dbo].[Account] ([Username], [Password], [Fullname], [Email], [Phone], [Gender], [IDNumber], [Nationality], [DOB], [Role]) VALUES (N'staff2', N'1', N'Leo Messi', N'messi10@gmail.com', N'97596612272', 0, N'152515189', N'Argentina', CAST(N'1985-03-03' AS Date), N'staff     ')
INSERT [dbo].[Account] ([Username], [Password], [Fullname], [Email], [Phone], [Gender], [IDNumber], [Nationality], [DOB], [Role]) VALUES (N'staff3', N'1', N'David De Gea', N'degea1@gmail.com', N'09759661153', 0, N'152515195', N'Spain', CAST(N'1990-03-11' AS Date), N'staff     ')
INSERT [dbo].[Account] ([Username], [Password], [Fullname], [Email], [Phone], [Gender], [IDNumber], [Nationality], [DOB], [Role]) VALUES (N'staff4', N'1', N'Perrick Aubameyang', N'auba11@gmail.com', N'97596652136', 0, N'123456789', N'Gabon', CAST(N'1989-12-12' AS Date), N'staff     ')
INSERT [dbo].[Account] ([Username], [Password], [Fullname], [Email], [Phone], [Gender], [IDNumber], [Nationality], [DOB], [Role]) VALUES (N'staff5', N'1', N'Atlatan Lacazette', N'messi10@gmail.com', N'97596624578', 0, N'152515111', N'France', CAST(N'1991-07-25' AS Date), N'staff     ')
INSERT [dbo].[Account] ([Username], [Password], [Fullname], [Email], [Phone], [Gender], [IDNumber], [Nationality], [DOB], [Role]) VALUES (N'zidane10', N'1', N'Zinedine Zidane', N'zidane10@gmail.com', N'01688721983', 0, N'003212475', N'France', CAST(N'1972-06-23' AS Date), N'customer  ')
INSERT [dbo].[Drink] ([DrinkID], [Name], [Description], [Price], [Status]) VALUES (N'D001', N'Orange Juice', N'Good', 20, 1)
INSERT [dbo].[Drink] ([DrinkID], [Name], [Description], [Price], [Status]) VALUES (N'D002', N'Apple Juice', N'Very Good', 20, 1)
INSERT [dbo].[Drink] ([DrinkID], [Name], [Description], [Price], [Status]) VALUES (N'D003', N'Banana Juice', N'Good', 20, 1)
INSERT [dbo].[Drink] ([DrinkID], [Name], [Description], [Price], [Status]) VALUES (N'D004', N'Mango Juice', N'Good', 20, 1)
INSERT [dbo].[Drink] ([DrinkID], [Name], [Description], [Price], [Status]) VALUES (N'D005', N'Beer 333', N'Good', 35, 1)
INSERT [dbo].[Drink] ([DrinkID], [Name], [Description], [Price], [Status]) VALUES (N'D006', N'Beer Tiger', N'Very Good', 45, 1)
INSERT [dbo].[Drink] ([DrinkID], [Name], [Description], [Price], [Status]) VALUES (N'D007', N'Beer Larue', N'Good', 35, 1)
INSERT [dbo].[Drink] ([DrinkID], [Name], [Description], [Price], [Status]) VALUES (N'D008', N'Sting', N'Good', 10, 1)
INSERT [dbo].[Drink] ([DrinkID], [Name], [Description], [Price], [Status]) VALUES (N'D009', N'Oolong Tea', N'Good', 10, 1)
INSERT [dbo].[Drink] ([DrinkID], [Name], [Description], [Price], [Status]) VALUES (N'D010', N'Number1', N'Good', 10, 1)
INSERT [dbo].[Food] ([FoodID], [Name], [Description], [Price], [Status]) VALUES (N'F001', N'Hotpot Seafood', N'Very good', 250.5, 1)
INSERT [dbo].[Food] ([FoodID], [Name], [Description], [Price], [Status]) VALUES (N'F002', N'King Crab Grilled', N'Very Good', 700, 1)
INSERT [dbo].[Food] ([FoodID], [Name], [Description], [Price], [Status]) VALUES (N'F003', N'Shrimp Hotpot', N'Good', 150, 1)
INSERT [dbo].[Food] ([FoodID], [Name], [Description], [Price], [Status]) VALUES (N'F004', N'SeaCrab Hotpot', N'Good', 150, 1)
INSERT [dbo].[Food] ([FoodID], [Name], [Description], [Price], [Status]) VALUES (N'F005', N'Tuna Hotpot', N'Good', 350, 1)
INSERT [dbo].[Food] ([FoodID], [Name], [Description], [Price], [Status]) VALUES (N'F006', N'Tuna Steamed', N'Very Good', 300, 1)
INSERT [dbo].[Food] ([FoodID], [Name], [Description], [Price], [Status]) VALUES (N'F007', N'Lobster N Noodles', N'Good', 500, 1)
INSERT [dbo].[Food] ([FoodID], [Name], [Description], [Price], [Status]) VALUES (N'F008', N'Lobster Hotpot', N'Good', 150, 1)
INSERT [dbo].[Food] ([FoodID], [Name], [Description], [Price], [Status]) VALUES (N'F010', N'Mussel Fried', N'Good', 150, 1)
INSERT [dbo].[Food] ([FoodID], [Name], [Description], [Price], [Status]) VALUES (N'F011', N'King Grab Grilled', N'Very Good', 800, 1)
INSERT [dbo].[Food] ([FoodID], [Name], [Description], [Price], [Status]) VALUES (N'F012', N'Octopus HotPot', N'Very Good', 650, 1)
INSERT [dbo].[Food] ([FoodID], [Name], [Description], [Price], [Status]) VALUES (N'F013', N'Octopus Grilled', N'More Delicious than your girl friend', 400, 1)
INSERT [dbo].[Food] ([FoodID], [Name], [Description], [Price], [Status]) VALUES (N'F015', N'Mussel Steamed With Garlic', N'', 350.5, 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R001', N'Single', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R002', N'Single', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R003', N'Single', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R004', N'Single', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R005', N'Single', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R006', N'Single', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R007', N'Single', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R008', N'Single', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R009', N'Single', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R010', N'Single', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R011', N'Couple', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R012', N'Couple', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R013', N'Couple', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R014', N'Couple', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R015', N'Couple', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R016', N'Couple', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R017', N'Couple', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R018', N'Couple', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R019', N'Couple', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R020', N'Couple', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R021', N'Family', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R022', N'Family', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R023', N'Family', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R024', N'Family', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R025', N'Family', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R026', N'Family', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R027', N'Family', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R028', N'Family', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R029', N'Family', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R030', N'Family', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R031', N'Group', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R032', N'Group', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R033', N'Group', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R034', N'Group', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R035', N'Group', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R036', N'Group', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R037', N'Group', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R038', N'Group', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R039', N'Group', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R040', N'Group', 1)
INSERT [dbo].[Room] ([RoomID], [RoomType], [Status]) VALUES (N'R041', N'Single', 1)
INSERT [dbo].[Room_Type] ([RoomType], [Description], [Quantity], [Capacity], [Price], [Status]) VALUES (N'Couple', N'For couples', 10, 2, 600, 1)
INSERT [dbo].[Room_Type] ([RoomType], [Description], [Quantity], [Capacity], [Price], [Status]) VALUES (N'Deluxe', N'asaas', 0, 5, 750.6, 0)
INSERT [dbo].[Room_Type] ([RoomType], [Description], [Quantity], [Capacity], [Price], [Status]) VALUES (N'Family', N'For families', 10, 6, 1000, 1)
INSERT [dbo].[Room_Type] ([RoomType], [Description], [Quantity], [Capacity], [Price], [Status]) VALUES (N'Group', N'For groups of friend', 10, 10, 1200, 1)
INSERT [dbo].[Room_Type] ([RoomType], [Description], [Quantity], [Capacity], [Price], [Status]) VALUES (N'Single', N'For one people', 11, 1, 500, 1)
INSERT [dbo].[Room_Type] ([RoomType], [Description], [Quantity], [Capacity], [Price], [Status]) VALUES (N'Special', N'For celebrities', 0, 2, 750.5, 0)
INSERT [dbo].[Service] ([ServiceID], [Name], [Price], [Description], [Status]) VALUES (N'S001', N'Swimming Pool Service', 80, N'Good', 1)
INSERT [dbo].[Service] ([ServiceID], [Name], [Price], [Description], [Status]) VALUES (N'S002', N'Breakfast Combo', 100, N'Very Good', 1)
INSERT [dbo].[Service] ([ServiceID], [Name], [Price], [Description], [Status]) VALUES (N'S003', N'Racing Ship', 120, N'Good', 1)
INSERT [dbo].[Service] ([ServiceID], [Name], [Price], [Description], [Status]) VALUES (N'S004', N'Massage', 150, N'Good', 1)
INSERT [dbo].[Service] ([ServiceID], [Name], [Price], [Description], [Status]) VALUES (N'S005', N'Hot Waterfall', 70, N'Good', 1)
INSERT [dbo].[Service] ([ServiceID], [Name], [Price], [Description], [Status]) VALUES (N'S006', N'Parachute', 90, N'Very Good', 1)
INSERT [dbo].[Service] ([ServiceID], [Name], [Price], [Description], [Status]) VALUES (N'S007', N'Surfing', 85, N'Good', 1)
INSERT [dbo].[Service] ([ServiceID], [Name], [Price], [Description], [Status]) VALUES (N'S008', N'Yacht', 400, N'Awsome', 1)
INSERT [dbo].[Service] ([ServiceID], [Name], [Price], [Description], [Status]) VALUES (N'S009', N'asdkj', 80000, N'asdawd', 1)
ALTER TABLE [dbo].[BookingInvoice]  WITH CHECK ADD  CONSTRAINT [FK_BookingInvoice_Account] FOREIGN KEY([Username])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[BookingInvoice] CHECK CONSTRAINT [FK_BookingInvoice_Account]
GO
ALTER TABLE [dbo].[BookingInvoice]  WITH CHECK ADD  CONSTRAINT [FK_BookingInvoice_Discount] FOREIGN KEY([DiscountCode])
REFERENCES [dbo].[Discount] ([DiscountCode])
GO
ALTER TABLE [dbo].[BookingInvoice] CHECK CONSTRAINT [FK_BookingInvoice_Discount]
GO
ALTER TABLE [dbo].[Invoice_Drink_Details]  WITH CHECK ADD  CONSTRAINT [FK_Invoice_Drink_Details_BookingInvoice] FOREIGN KEY([BookingID])
REFERENCES [dbo].[BookingInvoice] ([BookingID])
GO
ALTER TABLE [dbo].[Invoice_Drink_Details] CHECK CONSTRAINT [FK_Invoice_Drink_Details_BookingInvoice]
GO
ALTER TABLE [dbo].[Invoice_Drink_Details]  WITH CHECK ADD  CONSTRAINT [FK_Invoice_Drink_Details_Drink] FOREIGN KEY([DrinkID])
REFERENCES [dbo].[Drink] ([DrinkID])
GO
ALTER TABLE [dbo].[Invoice_Drink_Details] CHECK CONSTRAINT [FK_Invoice_Drink_Details_Drink]
GO
ALTER TABLE [dbo].[Invoice_Food_Details]  WITH CHECK ADD  CONSTRAINT [FK_Invoice_Food_Details_BookingInvoice] FOREIGN KEY([BookingID])
REFERENCES [dbo].[BookingInvoice] ([BookingID])
GO
ALTER TABLE [dbo].[Invoice_Food_Details] CHECK CONSTRAINT [FK_Invoice_Food_Details_BookingInvoice]
GO
ALTER TABLE [dbo].[Invoice_Food_Details]  WITH CHECK ADD  CONSTRAINT [FK_Invoice_Food_Details_Food] FOREIGN KEY([FoodID])
REFERENCES [dbo].[Food] ([FoodID])
GO
ALTER TABLE [dbo].[Invoice_Food_Details] CHECK CONSTRAINT [FK_Invoice_Food_Details_Food]
GO
ALTER TABLE [dbo].[Invoice_Room_Details]  WITH CHECK ADD  CONSTRAINT [FK_Invoice_Room_Details_BookingInvoice] FOREIGN KEY([BookingID])
REFERENCES [dbo].[BookingInvoice] ([BookingID])
GO
ALTER TABLE [dbo].[Invoice_Room_Details] CHECK CONSTRAINT [FK_Invoice_Room_Details_BookingInvoice]
GO
ALTER TABLE [dbo].[Invoice_Room_Details]  WITH CHECK ADD  CONSTRAINT [FK_Invoice_Room_Details_Room] FOREIGN KEY([RoomID])
REFERENCES [dbo].[Room] ([RoomID])
GO
ALTER TABLE [dbo].[Invoice_Room_Details] CHECK CONSTRAINT [FK_Invoice_Room_Details_Room]
GO
ALTER TABLE [dbo].[Invoice_Service_Details]  WITH CHECK ADD  CONSTRAINT [FK_Invoice_Service_Details_BookingInvoice] FOREIGN KEY([BookingID])
REFERENCES [dbo].[BookingInvoice] ([BookingID])
GO
ALTER TABLE [dbo].[Invoice_Service_Details] CHECK CONSTRAINT [FK_Invoice_Service_Details_BookingInvoice]
GO
ALTER TABLE [dbo].[Invoice_Service_Details]  WITH CHECK ADD  CONSTRAINT [FK_Invoice_Service_Details_Service] FOREIGN KEY([ServiceID])
REFERENCES [dbo].[Service] ([ServiceID])
GO
ALTER TABLE [dbo].[Invoice_Service_Details] CHECK CONSTRAINT [FK_Invoice_Service_Details_Service]
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD  CONSTRAINT [FK_Room_Room_Type] FOREIGN KEY([RoomType])
REFERENCES [dbo].[Room_Type] ([RoomType])
GO
ALTER TABLE [dbo].[Room] CHECK CONSTRAINT [FK_Room_Room_Type]
GO
USE [master]
GO
ALTER DATABASE [HomeStay] SET  READ_WRITE 
GO

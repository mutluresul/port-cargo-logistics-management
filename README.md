# Port Cargo and Logistics Management System
A console-based Java application for managing port cargo and logistics.

## Project Members

- Resul Mutlu
- Abdullah Kuşçular

## Project Idea

A console-based Java system for managing different types of cargo in a port. Users can add, remove, search, and update cargo.

## Superclass

- Name: `Cargo`
- Fields: `id`, `description`, `weightTons`, `destination`, `status`
- Methods: `displayInfo()`, `calculateStorageCost()`

## Subclasses

1. `ContainerCargo` — stores container information.
2. `BulkCargo` — represents cargo such as grain or coal.
3. `LiquidCargo` — represents liquids such as oil or fuel.

Each subclass overrides:

- `displayInfo()`
- `calculateStorageCost()`

## Interface

- Name: `Insurable`
- Method: `calculateInsuranceCost()`
- Implemented by: `ContainerCargo` and `LiquidCargo`

## Menu

1. Add cargo
2. Display all cargo
3. Search by ID
4. Remove cargo
5. Update cargo status
6. Show total weight
7. Exit

## Error Scenarios

- Invalid number or menu input
- Empty cargo ID or invalid weight
- Cargo ID not found

These errors will be handled using validation and specific `try/catch` blocks.

## Planned Classes

- `Cargo`
- `ContainerCargo`
- `BulkCargo`
- `LiquidCargo`
- `Insurable`
- `CargoManager`
- `ConsoleMenu`
- `Warehouse`
- `Main`

## Motivation

The class hierarchy separates common cargo information from cargo-specific behavior. `CargoManager` contains business logic, while `ConsoleMenu` handles user interaction.
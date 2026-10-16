# Port Cargo Management System
A console-based Java application for managing port cargo and logistics.

## Project Members

- Resul Mutlu
- Abdullah Kuscular

## Project Idea

A console-based Java system for managing different types of cargo in a port. Users can add, display, search, inspect, remove cargo, and check total weight and fees while enforcing port capacity limits.

## Superclass

- Name: `Cargo` (Abstract)
- Fields: `id`, `weight`
- Abstract / Polymorphic Methods: `calculateFee()`, `displayDetails()`

## Subclasses

1. `ContainerCargo` — represents standardized container units.
2. `BulkCargo` — represents cargo such as grain or coal (includes optional dry storage surcharge).
3. `LiquidCargo` — represents liquids such as oil or fuel (includes volume and hazardous material surcharge).

Each subclass overrides:

- `calculateFee()`
- `displayDetails()`

## Interface

- Name: `Inspectable`
- Method: `inspect()`
- Handles safety inspection status (`Pending` -> `Inspected`) for inspectable cargo types.

## Menu

1. Add cargo
2. Display all cargo
3. Search cargo by ID
4. Remove cargo
5. Inspect cargo
6. Show total weight
7. Show total fees
8. Exit

## Error Scenarios

- Invalid number or menu input (e.g., letters like 'AAA' or out-of-range option like '9')
- Exceeding maximum port weight capacity (`CapacityException`)
- Duplicate cargo ID, non-existent ID, or invalid weight/volume values

These errors are handled gracefully using validation and specific `try/catch` blocks to keep the system crash-proof.

## Project Classes

- `Cargo`
- `ContainerCargo`
- `BulkCargo`
- `LiquidCargo`
- `Inspectable`
- `PortManager`
- `ConsoleMenu`
- `CapacityException`
- `Main`

## Motivation

The class hierarchy separates common cargo properties from specific fee and inspection behaviors. `PortManager` contains core business logic and capacity enforcement, while `ConsoleMenu` handles user interaction and input validation (Separation of Concerns).